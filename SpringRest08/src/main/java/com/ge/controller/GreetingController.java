package com.ge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class GreetingController {

    /*If you want to access the information related to actuators, You need to visit http://localhost:8087/actuator.*/
    @GetMapping("/")
    public ResponseEntity<String> generateGreetings(){
        LocalDateTime dateTime = LocalDateTime.now();
        int hour = dateTime.getHour();
        String wish = null;
        if(hour<12){
            wish = "Good Morning";
        }
        else if(hour<16){
            wish = "Good Afternoon";
        }
        else if(hour<20){
            wish = "Good Evening";
        }
        else{
            wish = "Good Night";
        }
        return new ResponseEntity<String>(wish, HttpStatus.OK);
    }
}
