package com.ge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GreetMe {

    @Autowired
    private LocalDateTime dateTime;

    public GreetMe(){
        System.out.println("GreetMe Bean is Created.");
    }

    public String generateWish(String name){
        int hour = dateTime.getHour();
         if(hour < 12)
             return "Good Morning" + name;
         else if(hour < 16)
             return "Good Afternoon" + name;
         else if(hour < 20)
             return "Good Evening" + name;
         else
             return "Good Night" + name;
    }
}
