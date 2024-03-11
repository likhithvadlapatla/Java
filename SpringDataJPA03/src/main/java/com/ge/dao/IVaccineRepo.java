package com.ge.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVaccineRepo extends PagingAndSortingRepository<Vaccine, Integer>
{

}
