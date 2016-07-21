package com.celloud.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.celloud.model.UploadFile;

public class BoxDemoUtils {
    private static char separatorChar = File.separatorChar;
    private final static String UPLOAD_FILE_LIST = System.getProperty("user.home") + separatorChar + "Documents"
            + separatorChar + "testUpload" + separatorChar + "upload_file_list.csv";

    public static void saveUploadFile(UploadFile file) {
        File listFile = new File(UPLOAD_FILE_LIST);
        try {
            FileUtils.writeLines(listFile, "utf-8", Arrays.asList(new String[] { file.toCSVString() }), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateUploadFile(UploadFile file) {
        Map<String, UploadFile> files = mapUploadFile();
        files.put(file.getId(), file);
        reWriteAll(new ArrayList<>(files.values()));
    }

    public static List<UploadFile> listUploadFile() {
        Map<String, UploadFile> files = mapUploadFile();
        List<UploadFile> list = new ArrayList<>(files.values());
        Collections.sort(list, new Comparator<UploadFile>() {
            @Override
            public int compare(UploadFile f1, UploadFile f2) {
                return (int) (f1.getUploadTime().getTime() - f2.getUploadTime().getTime());
            }
        });
        return list;
    }

    public static UploadFile getOne(String id) {
        File listFile = new File(UPLOAD_FILE_LIST);
        UploadFile file = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(listFile));
            String line = null;
            while ((line = reader.readLine()) != null) {
                UploadFile temp = UploadFile.parse(line);
                if (temp != null && temp.getId().equals(id)) {
                    file = temp;
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    private static synchronized void reWriteAll(List<UploadFile> files) {
        Collections.sort(files, new Comparator<UploadFile>() {
            @Override
            public int compare(UploadFile f1, UploadFile f2) {
                return (int) (f1.getUploadTime().getTime() - f2.getUploadTime().getTime());
            }
        });
        List<String> lines = new ArrayList<>();
        for (UploadFile f : files) {
            lines.add(f.toCSVString());
        }
        File listFile = new File(UPLOAD_FILE_LIST);
        try {
            FileUtils.writeLines(listFile, "utf-8", lines, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, UploadFile> mapUploadFile() {
        File listFile = new File(UPLOAD_FILE_LIST);
        Map<String, UploadFile> map = new HashMap<>();
        if (!listFile.exists()) {
            return map;
        }
        try {
            List<String> lines = FileUtils.readLines(listFile);
            for (String line : lines) {
                UploadFile file = UploadFile.parse(line);
                map.put(file.getId(), file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void deleteUpladFile(String id) {
    }
}
