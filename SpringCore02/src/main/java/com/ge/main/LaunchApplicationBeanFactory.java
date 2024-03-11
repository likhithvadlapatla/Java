package com.ge.main;

import com.ge.bean.Employee;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class LaunchApplicationBeanFactory {
    public static void main(String args[]){

        /*If we use Bean Factory container, Lazy Loading takes place which means beans won't be created until it is requested.*/
        /*One of the Disadvantage of using Bean Factory Container/Interface is it's Lengthy Process*/
        /*Advantages :
        1.With one container(springIoc) you can use any number of configuration files.
        2.You can load your config file(applicationconfig.xml) how many ever times you want using any loop so that the beans can be created how many ever times you wanted which is not the case with ApplicationContext there you can only load the config file once.
        */
//      Resource resource = new ClassPathResource("applicationconfig.xml");
//      BeanFactory springIoc = new XmlBeanFactory(resource);

        DefaultListableBeanFactory springIoc = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader read = new XmlBeanDefinitionReader(springIoc);
        read.loadBeanDefinitions("applicationconfig.xml");

        Employee empBean1 = springIoc.getBean("employee1",Employee.class);
        String task = empBean1.employeeTask();
        System.out.println(empBean1);

        System.out.println("**********************************************");
        Employee empBean2 = springIoc.getBean("employee2",Employee.class);
        String task2 = empBean2.employeeTask();
        System.out.println(task2);
        System.out.println(empBean2);

        System.out.println("**********************************************");
        Employee empBean3 = springIoc.getBean("employee3",Employee.class);
        String task3 = empBean3.employeeTask();
        System.out.println(task3);
        System.out.println(empBean3);
    }
}
