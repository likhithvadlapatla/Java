package com.ge.services;

public class Mockito implements ICourses{
    @Override
    public Boolean getTheCourse() {
        System.out.println("Mockito course is purchased.");
        return true;
    }
}
