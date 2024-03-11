package com.ge.service;

import com.ge.dao.IVaccineRepo;
import com.ge.dao.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class VaccineServiceImpl implements IVaccineService{

    @Autowired
    private IVaccineRepo repo;

    @Override
    public List<Vaccine> fetchByCost(Integer cost) {
        return repo.findByCost(cost);
    }

    @Override
    public List<Vaccine> fetchByVaccineCompany(String companyName) {
        return repo.findByVaccineCompany(companyName);
    }

    @Override
    public List<Vaccine> fetchByVaccineCompanyIs(String companyName) {
        return repo.findByVaccineCompanyIs(companyName);
    }

    @Override
    public List<Vaccine> fetchByVaccineCompanyEquals(String companyName) {
        return repo.findByVaccineCompanyEquals(companyName);
    }

    @Override
    public List<Vaccine> fetchByCostLessThan(Integer cost) {
        return repo.findByCostLessThan(cost);
    }

    @Override
    public List<Vaccine> fetchByCostBetween(Integer startingCost, Integer endingCost) {
        return repo.findByCostBetween(startingCost, endingCost);
    }

    @Override
    public List<Vaccine> fetchByVaccineNameInAndCostBetween(Collection<String> vaccines, Integer startingCost, Integer endingCost) {
        return repo.findByVaccineNameInAndCostBetween(vaccines, startingCost, endingCost);
    }
}
