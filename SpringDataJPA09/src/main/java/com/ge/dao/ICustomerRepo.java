package com.ge.dao;

import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepo extends CrudRepository<CustomerInfo, Integer>
{

}
