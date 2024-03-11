package com.ge.service;

import com.ge.dao.Vaccine;

import java.util.Collection;
import java.util.List;
public interface IVaccineService {
    public List<Vaccine> fetchByCost(Integer cost);
    public List<Vaccine> fetchByVaccineCompany(String companyName);
    public List<Vaccine> fetchByVaccineCompanyIs(String companyName);
    public List<Vaccine> fetchByVaccineCompanyEquals(String companyName);
    public List<Vaccine> fetchByCostLessThan(Integer cost);
    public List<Vaccine> fetchByCostBetween(Integer startingCost, Integer endingCost);
    public List<Vaccine> fetchByVaccineNameInAndCostBetween(Collection<String> vaccines, Integer startingCost, Integer endingCost);
}
