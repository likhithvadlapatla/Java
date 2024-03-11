package com.ge.main;

import com.ge.service.GreetMe;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ge.config.JavaConfiguration;

public class LaunchApplication {
    public static void main(String args[]){
        ApplicationContext springIoc = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        GreetMe greet = springIoc.getBean(GreetMe.class);
        greet.generateWish("Likhith");
    }
}
