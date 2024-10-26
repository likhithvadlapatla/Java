package com.ge.api;

import com.ge.dto.NotificationRequest;
import com.ge.service.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private EmailNotificationService service1;

    @PostMapping("/sendNotification")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest){
        Long userId = notificationRequest.getUserId();
        String message = notificationRequest.getMessage();
        String email = notificationRequest.getEmail();

        System.out.println("User ID: "+userId);
        System.out.println("Message: "+message);

        service1.sendEmail(email,"Notification",message);
    }

}
