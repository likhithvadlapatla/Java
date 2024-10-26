package com.ge.model;

public class SpringBootCourse implements Course{

    @Override
    public boolean coursePurchased() {
        System.out.println("SpringBoot Course purchased.");
        return true;
    }
}
