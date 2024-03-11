package com.ge.service;

import com.ge.dao.CustomerInfo;
import com.ge.dao.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private ICustomerRepo repo;

    @Override
    public String registerCustomer(CustomerInfo cx) {
        Integer id = repo.save(cx).getId();
        return "Customer Information registered successfully with id : "+id;
    }

    @Override
    public Iterable<CustomerInfo> fetchAllCxInfo() {
        return repo.findAll();
    }
}
