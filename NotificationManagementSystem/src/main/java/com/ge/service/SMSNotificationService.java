package com.ge.service;
import org.springframework.stereotype.Service;

@Service
public interface SMSNotificationService {
    void sendSMS(String to, String message);
}
