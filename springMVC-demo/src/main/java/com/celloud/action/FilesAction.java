package com.celloud.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.celloud.utils.MD5Util;

@Controller
@RequestMapping("/files")
public class FilesAction {
    private static String upload_path = System.getProperty("user.home") + File.separatorChar + "Documents"
            + File.separatorChar + "testUpload";
    private static Logger logger = LoggerFactory.getLogger(FilesAction.class);

    @RequestMapping()
    public ModelAndView index(HttpSession session) {
        return new ModelAndView("upload/upload");
    }

    @RequestMapping("/upload1")
    public ModelAndView upload1(@RequestParam("file") CommonsMultipartFile[] files, HttpServletRequest request)
            throws InterruptedException {
        HttpSession session = request.getSession();
        Object userId = session.getAttribute("userId");
        long time = System.currentTimeMillis();
        for (int i = 0; i < files.length; i++) {
            System.out.println("fileName---------->" + files[i].getOriginalFilename());
            if (files[i].isEmpty()) {
                continue;
            }
            try {
                File file = new File(upload_path + File.separatorChar + files[i].getOriginalFilename());
                System.out.println(file.getAbsolutePath());
                OutputStream outputStream = new FileOutputStream(file);
                InputStream inputStream = files[i].getInputStream();
                byte[] temp = new byte[1024 * 1024];
                int length = 0;
                while ((length = inputStream.read(temp)) > 0) {
                    Thread.sleep(1000 * 10 * 6L);
                    System.out.println("继续上传。。。");
                    outputStream.write(temp, 0, length);
                }
                outputStream.flush();
                outputStream.close();
                inputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(System.currentTimeMillis() - time);
        System.out.println("开始上传时，获取到的userId：" + userId);
        userId = session.getAttribute("userId");
        System.out.println("上传结束时，获取到的userId：" + userId);
        // 相同5个文件，执行多次，每次执行时间在80-90毫秒之间
        return listFiles();
    }

    @RequestMapping("/upload2")
    public ModelAndView upload2(HttpServletRequest request, HttpServletResponse response) {
        // 创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            // 记录上传过程起始时的时间，用来计算上传时间
            long time = System.currentTimeMillis();
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                // 取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    // 取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (!"".equals(myFileName.trim())) {
                        System.out.println(myFileName);
                        // 重命名上传后的文件名
                        String fileName = upload_path + File.separatorChar + file.getOriginalFilename();
                        // 定义上传路径
                        File localFile = new File(fileName);
                        try {
                            file.transferTo(localFile);
                        } catch (IllegalStateException | IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                // 记录上传该文件后的时间

            }
            System.out.println(System.currentTimeMillis() - time);
            // 相同5个文件，执行多次，每次执行时间在1-6毫秒之间
        }
        return listFiles();
    }

    @RequestMapping("upload")
    @ResponseBody
    public Map<String, Object> upload(String name, Date lastModifiedDate, long size, Integer chunk, Integer chunks,
            @RequestParam("file") CommonsMultipartFile file) {
        Map<String, Object> result = new HashMap<>();
        if (file == null) {
            return result;
        }
        logger.info("name={}\tsize={}\tlastModifiedDate={}", name, size,
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(lastModifiedDate));
        String fileName = MD5Util.getMD5(name + "" + lastModifiedDate.getTime() + "" + size);
        String ext = name.substring(name.lastIndexOf("."));
        File chunkFile = new File(upload_path + File.separatorChar + fileName + ext + File.separatorChar + chunk);
        if (!chunkFile.exists()) {
            chunkFile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(chunkFile);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        logger.info("【{}】 chunk={}\t{}", name, chunk, getLoaded(fileName + ext));
        if (chunks == null || chunks == 0 || chunk == chunks - 1) {
            logger.info("文件上传完成【{}】", name);
            File tempFile = chunkFile.getParentFile();
            int total = chunks == null ? 0 : chunks.intValue();
            File f = new File(tempFile.getParentFile().getAbsolutePath() + File.separatorChar + name);
            try {
                for (int i = 0; i < total; i++) {// 有可能是性能瓶颈
                    FileUtils.writeByteArrayToFile(f, FileUtils.readFileToByteArray(
                            new File(tempFile.getAbsolutePath() + File.separatorChar + i)), i != 0);
                }
                FileUtils.forceDelete(tempFile);
            } catch (IOException e) {
                logger.error("合并文件失败！", e);
            }
            result.put("md5", MD5Util.getFileMD5(f));
        }
        return result;
    }

    @RequestMapping("checkBreakpoints")
    @ResponseBody
    public Map<String, Object> checkBreakpoints(String name, Date lastModifiedDate, long size) {
        String filename = MD5Util.getMD5(name + "" + lastModifiedDate.getTime() + "" + size);
        String ext = name.substring(name.lastIndexOf("."));
        Map<String, Object> result = new HashMap<>();
        result.put("loaded", getLoaded(filename + ext));
        return result;
    }

    public long getLoaded(String filename) {
        File file = new File(upload_path + File.separatorChar + filename);
        logger.info(file.getAbsolutePath());
        long loaded = 0L;
        if (!file.exists() || file.isFile()) {
            return loaded;
        }
        File[] files = file.listFiles();
        if (files == null || files.length == 0) {
            return loaded;
        }
        for (int i = 0; i <= files.length; i++) {
            File f = new File(upload_path + File.separatorChar + filename + File.separatorChar + i);
            if (!f.exists()) {
                break;
            }
            loaded += f.length();
        }
        return loaded;
    }

    @RequestMapping("listfiles")
    public ModelAndView listFiles() {
        ModelAndView mv = new ModelAndView("upload/listfiles");
        File file = new File(upload_path);
        String[] files = file.list();
        mv.addObject("files", files);
        return mv;
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(String filename) throws Exception {
        System.out.println(filename);
        File file = new File(upload_path + File.separatorChar + filename);
        HttpHeaders headers = new HttpHeaders();
        String fileName = new String(filename.getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
}
