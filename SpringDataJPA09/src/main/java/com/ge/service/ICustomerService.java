package com.ge.service;

import com.ge.dao.CustomerInfo;

public interface ICustomerService {
    public String registerCustomer(CustomerInfo cx);
    public Iterable<CustomerInfo> fetchAllCxInfo();
}
