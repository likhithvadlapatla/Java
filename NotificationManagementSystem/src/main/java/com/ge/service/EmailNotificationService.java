package com.ge.service;
import org.springframework.stereotype.Service;

@Service
public interface EmailNotificationService {
    void sendEmail(String to, String subject, String body);
}
