package com.ge.service;

import com.ge.dao.IVaccineRepo;
import com.ge.dao.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class VaccineServiceImpl implements IVaccineService {

    @Autowired
    private IVaccineRepo repo;

    public String registerVaccineInfo(Vaccine vaccineInfo){
        Vaccine vaccine = repo.save(vaccineInfo);
        return "Vaccine with id "+ vaccine.getId() + " successfully.";
    }
    @Override
    public Iterable<Vaccine> registerMultipleVaccines(Iterable<Vaccine> vaccines) {
        return repo.saveAll(vaccines);
    }
    @Override
    public Long getVaccineCount() {
        return repo.count();
    }

    @Override
    public Boolean checkAvailability(Integer id) {
        return repo.existsById(id);
    }

    @Override
    public Iterable<Vaccine> getAllVaccinesInfo() {
        return repo.findAll();
    }

    @Override
    public Iterable<Vaccine> getAllVaccinesInfoSpecific(Iterable<Integer> ids) {
        return repo.findAllById(ids);
    }

    @Override
    public Optional<Vaccine> getVaccineById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public String removeVaccineById(Integer id) {
        Boolean status = repo.existsById(id);
        if(status == true){
            repo.deleteById(id);
            return "Vaccine with id "+id+" deleted.";
        }
        return "Vaccine details with the given id is not found";
    }

    @Override
    public String removeVaccineByIds(List<Integer> ids) {
        List<Vaccine> vaccineList = (List<Vaccine>) repo.findAllById(ids);
        if(vaccineList.size() == ids.size()){
            repo.deleteAllById(ids);
            return "Vaccines with given id's are deleted";
        }
        return "Vaccines with given id's are not deleted";
    }

    @Override
    public String removeVaccineUsingVaccineObj(Vaccine vaccine) {
        Integer id = vaccine.getId();
        Optional<Vaccine> vac = repo.findById(id);
        if(vac.isPresent()){
            repo.delete(vaccine);
            return "Vaccine details deleted";
        }
        return "Failed to delete vaccine";
    }


}
