package com.ge.services;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private String name;
    private Integer id;

    public Student(){
        System.out.println("Student Bean is Created.");
    }

    public void initializeData(){
        name = "Likhith";
        id = 01;
        System.out.println(name+ " " +id);
    }
}
