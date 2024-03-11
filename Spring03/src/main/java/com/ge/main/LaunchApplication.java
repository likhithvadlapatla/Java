package com.ge.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchApplication {
    public static void main(String args[]){
        ApplicationContext springIoc = new ClassPathXmlApplicationContext("applicationconfig.xml");
    }
}
