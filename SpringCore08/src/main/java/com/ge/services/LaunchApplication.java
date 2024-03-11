package com.ge.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LaunchApplication {
    public static void main(String[] args){
        ApplicationContext springIoc = SpringApplication.run(LaunchApplication.class, args);
        /*The print statement below prints the name of the class which is responsible for activating the spring framework behind the scenes.*/
        /*AnnotationConfigApplicationContext*/
        System.out.println(springIoc.getClass().getName());
        /*The print statement below depicts the number of beans created by the SpringBoot application to enable Auto Configuration of Spring Framework behind the scenes*/
        System.out.println("Number of Beans created behind the scenes : " + springIoc.getBeanDefinitionCount());
        /*The print statement below depicts the names of beans created by the SpringBoot application to enable Auto Configuration of Spring Framework behind the scenes*/
        String beanNames[] = springIoc.getBeanDefinitionNames();
        for(String name:beanNames){
            System.out.print(name + " : ");
        }
        System.out.println();
        Student st = springIoc.getBean(Student.class);
        st.initializeData();
    }
}
