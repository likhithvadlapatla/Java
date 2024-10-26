package com.ge.advice;

import java.time.LocalDateTime;

public class ErrorDetails {
    private String statusCode;
    private String msg;
    private LocalDateTime when;

    public ErrorDetails() {
        super();
    }

    public ErrorDetails(String statusCode, String msg, LocalDateTime when) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.when = when;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LocalDateTime getWhen() {
        return when;
    }

    public void setWhen(LocalDateTime when) {
        this.when = when;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "statusCode='" + statusCode + '\'' +
                ", msg='" + msg + '\'' +
                ", when=" + when +
                '}';
    }
}
