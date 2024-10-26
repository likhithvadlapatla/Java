package com.ge.stream;

import com.ge.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.function.Supplier;

@Service
public class EmployeeProducer {

    /*In the case of Spring Cloud Stream, it(@Bean) allows Spring to recognize the Supplier (message producer) and Consumer (message consumer) functions and manage them as part of the messaging system.*/

    @Bean
    public Supplier<Employee> sendEmployeeMessage(){
        return () -> new Employee(1, "Likhith", "Software Engineer");
    }
}
