package com.ge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Configuration
@ComponentScan(basePackages = {"com.ge"})
public class JavaConfiguration {

    public JavaConfiguration(){
        System.out.println("Java Configuration bean has been created");
    }

    /*One of the advantage of this annotation is when you have a class whose code is already written by the Java team(like LocalDateTime in this example), you can tell spring to create the bean by using this annotation.*/
    @Bean
    public LocalDateTime createDateBean(){
        System.out.println("LocalDateTime has been created manually and then configured as a bean.");
        return LocalDateTime.now();
    }
}

/*The problem with this pure annotation approach (Using JavaConfiguration file), any small change in the configuration file requires the execution of entire application.*/
