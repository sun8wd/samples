package com.celloud.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.celloud.model.UploadFile;
import com.celloud.utils.BoxDemoUtils;
import com.celloud.utils.CompressionUtils;
import com.celloud.utils.MD5Util;
import com.celloud.utils.OSSUtils;

@Controller
@RequestMapping("box")
public class BoxDemoAction {
    private static char separatorChar = File.separatorChar;
    private static String upload_path = System.getProperty("user.home") + separatorChar + "Documents" + separatorChar
            + "testUpload";
    private static Logger logger = LoggerFactory.getLogger(BoxDemoAction.class);

    @RequestMapping()
    public String index() {
        return "box/upload";
    }

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("box/list").addObject("files", BoxDemoUtils.listUploadFile());
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
        String fileFingerprint = MD5Util.getMD5(name + "" + lastModifiedDate.getTime() + "" + size);
        String ext = name.substring(name.lastIndexOf("."));
        File chunkFile = new File(upload_path + separatorChar + fileFingerprint + ext + separatorChar + chunk);
        if (!chunkFile.exists()) {
            chunkFile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(chunkFile);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        logger.info("【{}】 chunk={}\t{}", name, chunk, getLoaded(fileFingerprint + ext));
        if (chunks == null || chunks == 0 || chunk == chunks - 1) {
            logger.info("文件上传完成【{}】", name);
            String id = new ObjectId().toString();
            UploadFile uf = new UploadFile();
            uf.setId(id);
            uf.setFilename(name);
            File tempFile = chunkFile.getParentFile();
            int total = chunks == null ? 0 : chunks.intValue();
            name = name.replaceAll(" ", "-");
            File f = new File(tempFile.getParentFile().getAbsolutePath() + separatorChar + id + ext);
            uf.setFilePath(f.getAbsolutePath());
            try {
                for (int i = 0; i < total; i++) {// 有可能是性能瓶颈
                    FileUtils.writeByteArrayToFile(f,
                            FileUtils.readFileToByteArray(new File(tempFile.getAbsolutePath() + separatorChar + i)),
                            i != 0);
                }
                FileUtils.forceDelete(tempFile);
                uf.setFilesize(f.length());
                uf.setFingerprint(fileFingerprint);
            } catch (IOException e) {
                logger.error("合并文件失败！", e);
            }
            String md5 = MD5Util.getFileMD5(f);
            uf.setUploadTime(new Date());
            result.put("md5", md5);
            result.put("id", id);
            uf.setMd5(md5);
            BoxDemoUtils.saveUploadFile(uf);
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

    @RequestMapping("sync")
    @ResponseBody
    public String sync(String id) {
        UploadFile uf = BoxDemoUtils.getOne(id);
        File f = new File(uf.getFilePath());
        String zipFilePath = CompressionUtils.fastq(f);
        File zipFile = new File(zipFilePath);
        String ext = zipFile.getName().substring(zipFile.getName().lastIndexOf("."));
        String url = OSSUtils.upload(uf.getId() + "/" + uf.getFilename() + ext, zipFile);
        uf.setZipPath(zipFilePath);
        uf.setObjectUrl(url);
        uf.setZipSize(zipFile.length());
        BoxDemoUtils.updateUploadFile(uf);
        return uf.toCSVString();
    }

    @RequestMapping("deleteAll")
    @ResponseBody
    public String deleteAll() {
        String result = "ok";
        File file = new File(upload_path);
        logger.info("deleting...");
        OSSUtils.clearBucket();
        if (file.exists()) {
            try {
                FileUtils.deleteDirectory(file);
            } catch (IOException e) {
                result = "fail";
                e.printStackTrace();
            }
        }
        file.mkdirs();
        return result;
    }

    private long getLoaded(String filename) {
        File file = new File(upload_path + separatorChar + filename);
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
            File f = new File(upload_path + separatorChar + filename + separatorChar + i);
            if (!f.exists()) {
                break;
            }
            loaded += f.length();
        }
        return loaded;
    }

}
