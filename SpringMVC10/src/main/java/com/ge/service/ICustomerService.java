package com.ge.service;

import com.ge.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICustomerService {
    public List<Customer> getCustomerInfo();
}
