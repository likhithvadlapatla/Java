package com.ge.main;

import com.ge.bean.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchApplication {

    public static void main(String args[]){
        /*If we use Application Context container, eager Loading takes place which means beans will be created when the spring container is activated.*/
        ApplicationContext springIoc = new ClassPathXmlApplicationContext("applicationconfig.xml");

        Employee empBean1 = springIoc.getBean("employee1",Employee.class);
        String task = empBean1.employeeTask();
        System.out.println(task);
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
