package com.ge.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVaccineRepo extends CrudRepository<Vaccine, Integer>
{

}
