package com.ge.service;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;

@Service
public class SMSNotificationServiceImpl implements SMSNotificationService{

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token")
    private String authToken;

    @Value("${twilio.from.phone.number")
    private String fromPhoneNumber;

    /*
        The Twilio.init method sets up the Twilio SDK with your credentials. Once initialized, you can use the SDK to interact with Twilio’s services (e.g., sending SMS).
     */
    @PostConstruct
    public void initTwilio() {
        // Ensure the SID and Auth Token are correctly set
        if (accountSid == null || authToken == null) {
            throw new IllegalStateException("Twilio credentials are not set properly.");
        }
        Twilio.init(accountSid, authToken);
    }

    /*
        Message.creator is used to create and send an SMS message through Twilio's API.
     */
    @Override
    public void sendSMS(String to, String message) {
        Message.creator(
                new PhoneNumber(to),
                new PhoneNumber(fromPhoneNumber),
                message
        ).create();
    }
}
