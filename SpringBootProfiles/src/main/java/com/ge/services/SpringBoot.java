package com.ge.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("SB") /*If you use spring.profiles.include property in application.properties file and equate the string that you have mentioned in the profile annotation to that property, this bean gets autowired into course variable in main file by dominating the @Primary annotation.*/
public class SpringBoot implements ICourses{
    @Override
    public Boolean getTheCourse() {
        System.out.println("SpringBoot Course is purchased.");
        return true;
    }
}
