package com.document.model;

public class DocumentResponse {
    private boolean success;
    private String message;
    private String filePath;
    private String fileName;

    public DocumentResponse() {}

    public DocumentResponse(boolean success, String message, String filePath, String fileName) {
        this.success = success;
        this.message = message;
        this.filePath = filePath;
        this.fileName = fileName;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}