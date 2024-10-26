package com.ge.app;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Update {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

        // Example plain text passwords
        String[] passwords = {"Likhith@1", "Triveni@7"};

        for (String password : passwords) {
            String encodedPassword = encoder.encode(password);
            System.out.println("Plain Text: " + password);
            System.out.println("Encoded: " + encodedPassword);
        }
    }
}