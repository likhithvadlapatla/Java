package com.ge.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class LaunchApplication {
    public static void main(String args[]){
        /*This line is used to activate the Spring Framework.*/
        ApplicationContext springIoc = SpringApplication.run(LaunchApplication.class, args);

        Amazon amz = springIoc.getBean(Amazon.class);
        Boolean status = amz.deliverTheProduct(333.00);

        if(status)
            System.out.println("Product Delivered!");
        else
            System.out.println("Failed to Deliver!");
    }
}
