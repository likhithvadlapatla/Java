package com.ge.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile("Devops")
public class DevOps implements ICourses{

    @Override
    public Boolean getTheCourse() {
        System.out.println("DevOps course is purchased.");
        return true;
    }
}
