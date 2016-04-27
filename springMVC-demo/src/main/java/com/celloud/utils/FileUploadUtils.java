package com.celloud.utils;

import java.util.HashMap;
import java.util.Map;

import com.celloud.model.FileUpload;

public class FileUploadUtils {
    private static Map<Integer, FileUpload> files = new HashMap<>();
    private static int nextId = 1;

    public synchronized static void add(FileUpload file) {
        file.setId(nextId);
        files.put(nextId, file);
        nextId++;
    }

    public synchronized static void update(FileUpload file) {
        files.put(file.getId(), file);
    }

    public static FileUpload get(String breakpointsMd5) {
        for (FileUpload file : files.values()) {
            if (file.getBreakpointsMd5().equals(breakpointsMd5)) {
                return file;
            }
        }
        return null;
    }

    public synchronized static void remove(int id) {
        files.remove(id);
    }
}
