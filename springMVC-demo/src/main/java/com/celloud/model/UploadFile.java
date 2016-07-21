package com.celloud.model;

import java.text.DecimalFormat;
import java.util.Date;

import com.celloud.utils.OSSUtils;

public class UploadFile {
    private String id;
    private String filename;
    private String md5;
    private Long filesize;
    private String filePath;
    private Date uploadTime;
    private String zipPath;
    private Long zipSize;
    private String fingerprint;
    private String objectUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Long getFilesize() {
        return filesize;
    }

    public void setFilesize(Long filesize) {
        this.filesize = filesize;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getZipPath() {
        return zipPath;
    }

    public void setZipPath(String zipPath) {
        this.zipPath = zipPath;
    }

    public long getZipSize() {
        return zipSize;
    }

    public void setZipSize(Long zipSize) {
        this.zipSize = zipSize;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getFileSizeString() {
        return OSSUtils.formatSize(this.filesize);
    }

    public String getZipFileSizeString() {
        if (this.zipSize == null) {
            return "压缩中。。。";
        }
        return OSSUtils.formatSize(this.zipSize);
    }

    public String getCompressionRatio() {
        if(this.zipSize==null){
            return "---";
        }
        double result = (double) this.zipSize / (double) this.filesize;
        return new DecimalFormat("#.00").format(result * 100)+"%";
    }

    public String getObjectUrl() {
        return objectUrl;
    }

    public void setObjectUrl(String objectUrl) {
        this.objectUrl = objectUrl;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String toCSVString() {
        if (id == null) {
            return null;
        }
        StringBuffer result = new StringBuffer();
        result.append(id + ",");
        result.append(filename.replaceAll(",", "@@@逗号@@@") + ",");
        result.append(filePath.replaceAll(",", "@@@逗号@@@") + ",");
        result.append(fingerprint + ",");
        result.append(filesize + ",");
        result.append(md5 + ",");
        result.append(uploadTime.getTime() + ",");
        result.append((zipPath == null ? " " : zipPath.replaceAll(",", "@@@逗号@@@")) + ",");
        result.append((zipSize == null ? " " : zipSize.longValue()) + ",");
        result.append(objectUrl == null ? " " : objectUrl.replaceAll(",", "@@@逗号@@@"));
        return result.toString();
    }

    public static UploadFile parse(String csvString) {
        if (csvString == null || csvString.trim().length() == 0) {
            return null;
        }
        String[] strs = csvString.split(",");
        if (strs == null || strs.length != 10) {
            return null;
        }
        UploadFile file = new UploadFile();
        file.setId(strs[0]);
        file.setFilename(strs[1].replaceAll("@@@逗号@@@", ","));
        file.setFilePath(strs[2].replaceAll("@@@逗号@@@", ","));
        file.setFingerprint(strs[3]);
        file.setFilesize(Long.parseLong(strs[4].trim()));
        file.setMd5(strs[5]);
        file.setUploadTime(new Date(Long.parseLong(strs[6].trim())));
        file.setZipPath(strs[7].trim().length() == 0 ? null : strs[7].trim().replaceAll("@@@逗号@@@", ","));
        file.setZipSize(strs[8].trim().length() == 0 ? null : Long.parseLong(strs[8].trim()));
        file.setObjectUrl(strs[9].trim().length() == 0 ? null : strs[9].trim().replaceAll("@@@逗号@@@", ","));
        return file;
    }

}
