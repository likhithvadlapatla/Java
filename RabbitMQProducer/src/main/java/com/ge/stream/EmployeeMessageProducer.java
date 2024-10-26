package com.ge.stream;

import com.ge.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@EnableBinding(EmployeeMessageSource.class)
@Service
public class EmployeeMessageProducer {

    @Autowired
    private EmployeeMessageSource employeeMessageSource;

    public void sendEmployeeMessage(Employee employee){
        employeeMessageSource.employeeOutput().send(MessageBuilder.withPayload(employee).build());
    }
}
