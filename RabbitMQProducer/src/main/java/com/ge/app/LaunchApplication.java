package com.ge.app;

import com.ge.model.Employee;
import com.ge.stream.EmployeeMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@ComponentScan(basePackages = "com.ge")
public class LaunchApplication {

    @Autowired
    private EmployeeMessageProducer employeeMessageProducer;

    public static void main(String[] args) {
        SpringApplication.run(LaunchApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendMessageAfterStartup() {
        Employee employee = new Employee(1, "John Doe", "Software Engineer");
        employeeMessageProducer.sendEmployeeMessage(employee);
    }
}
