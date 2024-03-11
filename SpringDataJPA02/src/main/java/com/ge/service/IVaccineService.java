package com.ge.service;

import com.ge.dao.Vaccine;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface IVaccineService {
    public String registerVaccineInfo(Vaccine vaccineInfo);
    public Iterable<Vaccine> registerMultipleVaccines(Iterable<Vaccine> vaccines);
    public Long getVaccineCount();
    public Boolean checkAvailability(Integer id);
    public Iterable<Vaccine> getAllVaccinesInfo();
    public Iterable<Vaccine> getAllVaccinesInfoSpecific(Iterable<Integer> ids);
    public Optional<Vaccine> getVaccineById(Integer id);
    public String removeVaccineById(Integer id);
    public String removeVaccineByIds(List<Integer> ids);
    public String removeVaccineUsingVaccineObj(Vaccine vaccine);
}
