package com.ge.service;

import com.ge.dao.IVaccineRepo;
import com.ge.dao.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineServiceImpl implements IVaccineService{

    @Autowired
    private IVaccineRepo repo;

    @Override
    public List<Vaccine> fetchByVaccineCompanyName(String c) {
        return repo.searchByVaccineCompanyName(c);
    }

    @Override
    public List<Vaccine> fetchByVaccineCompanyName(String comp1, String comp2) {
        return repo.searchByVaccineCompanyName(comp1,comp2);
    }

    @Override
    public List<String> fetchByVaccinePriceRange(Integer minP, Integer maxP) {
        return repo.searchByVaccinePriceRange(minP,maxP);
    }

    @Override
    public List<Object[]> fetchVaccineInfoByVaccineName(String vac1, String vac2) {
        return repo.searchVaccineInfoByVaccineName(vac1, vac2);
    }

    @Override
    public int UpdatePriceByVaccineName(Integer newCost, String vac) {
        return repo.updatePriceByVaccineName(newCost,vac);
    }

    @Override
    public int deleteVaccineByPriceRange(Integer minP, Integer maxP) {
        return repo.deleteByVaccinePriceRange(minP, maxP);
    }

    @Override
    public int insertVaccineInfo(Integer id, String vaccineName, String vaccineCompany, Integer cost) {
        return repo.insertVaccineDetails(id, vaccineName, vaccineCompany, cost);
    }
}
