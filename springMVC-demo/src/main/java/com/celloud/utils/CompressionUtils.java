package com.celloud.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.celloud.constants.Constants;

public class CompressionUtils {
    private static Logger logger = LoggerFactory.getLogger(CompressionUtils.class);

    public static String fastq(String path) {
        return fastq(new File(path));
    }

    public static String fastq(File file) {
        logger.info("正在压缩文件：{}", file.getAbsolutePath());
        String output = file.getParent() + File.separatorChar + file.getName() + ".zip";
        File target = new File(output);
        if (target.exists()) {
            target.delete();
        }
        String cmd = Constants.getProperty("cmd");
        cmd = cmd.replace("{input}", file.getAbsolutePath());
        cmd = cmd.replace("{output}", output);
        logger.info("cmd:{}", cmd);
        exeCmd(cmd);
        logger.info("文件压缩完成：{}", output);
        return output;
    }

    public static void exeCmd(String commandStr) {
        BufferedReader br = null;
        try {
            Process p = Runtime.getRuntime().exec(commandStr);
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
