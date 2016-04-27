package com.celloud.model;

public class FileUpload {
    private int id;
    private String name;
    private String path;
    private String md5;
    private String breakpointsMd5;
    private int chunks;
    private int lastChunk;
    private long size;
    private long loaded;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getBreakpointsMd5() {
        return breakpointsMd5;
    }

    public void setBreakpointsMd5(String breakpointsMd5) {
        this.breakpointsMd5 = breakpointsMd5;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public int getChunks() {
        return chunks;
    }

    public void setChunks(int chunks) {
        this.chunks = chunks;
    }

    public int getLastChunk() {
        return lastChunk;
    }

    public void setLastChunk(int lastChunk) {
        this.lastChunk = lastChunk;
    }

    public long getLoaded() {
        return loaded;
    }

    public void setLoaded(long loaded) {
        this.loaded = loaded;
    }

}
