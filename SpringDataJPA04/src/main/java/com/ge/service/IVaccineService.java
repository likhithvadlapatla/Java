package com.ge.service;

import com.ge.dao.Vaccine;
import java.util.List;
public interface IVaccineService {
    public List<Vaccine> searchByGivenVaccineInfo(Vaccine vaccine, boolean status, String... properties);
    public Vaccine searchVaccineById(Integer id);
    public List<Vaccine> searchVaccineByObject(Vaccine vaccine);
    public String removeVaccineInfo(Iterable<Integer> ids);
}
