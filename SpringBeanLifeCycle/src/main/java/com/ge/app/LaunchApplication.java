package com.ge.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LaunchApplication {
    public static void main(String[] args){
        System.out.println("Spring IOC Container started.");
        ConfigurableApplicationContext context = SpringApplication.run(LaunchApplication.class, args);

        Voter voter = context.getBean(Voter.class);
        String message = voter.checkEligibility(18);
        System.out.println(message);
        context.close();

        System.out.println("Spring IOC Container stopped");
    }
}
