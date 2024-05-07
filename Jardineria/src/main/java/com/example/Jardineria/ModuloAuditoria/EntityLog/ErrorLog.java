package com.example.Jardineria.ModuloAuditoria.EntityLog;

import java.util.Date;

public class ErrorLog {
    private Date timestamp;
    private String errorType;
    private String errorMessage;

    public ErrorLog(Date timestamp, String errorType, String errorMessage) {
        this.timestamp = timestamp;
        this.errorType = errorType;
        this.errorMessage = errorMessage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
