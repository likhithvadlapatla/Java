package com.ge.service;

import com.ge.dao.Vaccine;

import java.util.List;

public interface IVaccineService {
    public List<Vaccine> fetchByVaccineCompanyName(String c);
    public List<Vaccine> fetchByVaccineCompanyName(String comp1, String comp2);
    public List<String> fetchByVaccinePriceRange(Integer minP, Integer maxP);
    public List<Object[]> fetchVaccineInfoByVaccineName(String vac1, String vac2);
    public int UpdatePriceByVaccineName(Integer newCost, String vac);
    public int deleteVaccineByPriceRange(Integer minP, Integer maxP);
    public int insertVaccineInfo(Integer id, String vaccineName, String vaccineCompany, Integer cost);
}
