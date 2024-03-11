package com.ge.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IVaccineRepo extends JpaRepository<Vaccine, Integer>
{
    /*Syntax to follow to name the methods : findByPropertyKeywords.*/
    public List<Vaccine> findByCost(Integer cost);
    public List<Vaccine> findByVaccineCompany(String companyName);
    public List<Vaccine> findByVaccineCompanyIs(String companyName);
    public List<Vaccine> findByVaccineCompanyEquals(String companyName);
    public List<Vaccine> findByCostLessThan(Integer cost);
    public List<Vaccine> findByCostBetween(Integer startingCost, Integer endingCost);
    public List<Vaccine> findByVaccineNameInAndCostBetween(Collection<String> vaccines, Integer startingCost, Integer endingCost);
}