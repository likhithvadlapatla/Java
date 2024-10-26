package com.ge.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface EmployeeMessageSink {
    String Input = "employeeInputChannel";
    @Input(Input)
    SubscribableChannel employeeInput();
}
