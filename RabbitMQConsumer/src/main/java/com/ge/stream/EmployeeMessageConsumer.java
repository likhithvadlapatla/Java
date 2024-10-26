package com.ge.stream;

import com.ge.model.Employee;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@EnableBinding(EmployeeMessageSink.class)
@Service
public class EmployeeMessageConsumer {

    @StreamListener(EmployeeMessageSink.Input)
    public void handleEmployeeMessage(Employee employee){
        System.out.println(employee.toString());
    }
}
