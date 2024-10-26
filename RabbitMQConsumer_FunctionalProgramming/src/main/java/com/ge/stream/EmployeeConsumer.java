package com.ge.stream;

import com.ge.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class EmployeeConsumer {

    @Bean
    public Consumer<Employee> handleEmployeeMessage(){
        return employee -> System.out.println("Received Employee: " + employee.toString());
    }
}
