package com.ge.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EmployeeMessageSource {
    String Output = "employeeOutputChannel";
    @Output(Output)
    MessageChannel employeeOutput();
}
