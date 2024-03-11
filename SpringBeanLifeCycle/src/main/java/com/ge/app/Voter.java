package com.ge.app;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
/*This annotation is used to specify where the external file is present to retrieve the values from using @Value annotation in the code.*/
@PropertySource(value = "application.properties")
public class Voter {
    @Value("${voter.info.name}")
    private String name;

    /*This annotation is used to take external properties defined in other files(application.properties in this case) to the java code.*/
    @Value("${voter.info.id}")
    private Integer id;

    static
    {
        System.out.println("Voter class is loaded.");
    }

    public Voter(){
        System.out.println("Voter bean is created.");
    }

    @PostConstruct
    public void myInit(){
        System.out.println("Init method getting invoked post constructor call.");
    }

    public String checkEligibility(int age){
        System.out.println("Hello "+name+" Your Id number is "+id);
        if(age<18){
            return "Have Patience! Your time will come";
        }
        return "You are eligible to vote";
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destroyed");
    }
}
