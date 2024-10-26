package com.ge.dto;

public class NotificationRequest {

    private Long userId;
    private String message;
    private String email;

    public NotificationRequest() {
    }

    public NotificationRequest(Long userId, String message, String email) {
        this.userId = userId;
        this.message = message;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "NotificationRequest{" +
                "userId=" + userId +
                ", message='" + message + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
