package com.ge.service;

import com.ge.dao.ICustomerRepo;
import com.ge.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    public ICustomerRepo repo;

    @Override
    public List<Customer> getCustomerInfo() {
        return (List<Customer>)repo.findAll();
    }
}
