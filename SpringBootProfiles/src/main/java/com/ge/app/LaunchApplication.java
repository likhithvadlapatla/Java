package com.ge.app;

import com.ge.services.ICourses;
import com.ge.services.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@ComponentScan(basePackages = "com.ge")
public class LaunchApplication implements CommandLineRunner {

    @Autowired
    private ICourses course;
    public static void main(String[] args){
        SpringApplication.run(LaunchApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        Boolean status = course.getTheCourse();
        if(status){
            System.out.println("Enrolled to course successfully.");
        }
        else{
            System.out.println("Failed to enroll.");
        }
    }

    @Bean
    @Profile("Mock")
    public Mockito createMockitoBean(){
        return new Mockito();
    }
}
