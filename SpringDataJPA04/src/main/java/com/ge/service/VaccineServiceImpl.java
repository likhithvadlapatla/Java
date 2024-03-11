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
import java.util.List;
import java.util.Optional;

@Service
public class VaccineServiceImpl implements IVaccineService{

    @Autowired
    private IVaccineRepo repo;

    @Override
    public List<Vaccine> searchByGivenVaccineInfo(Vaccine vaccine, boolean status, String... properties) {
        Example<Vaccine> example = Example.of(vaccine);
        Sort sort = Sort.by(status? Sort.Direction.ASC: Sort.Direction.DESC,properties);
        return repo.findAll(example,sort);
    }

    @Override
    public Vaccine searchVaccineById(Integer id) {
        Optional<Vaccine> vaccine = repo.findById(id);
        if(vaccine.isPresent()){
            return vaccine.get();
        }
        return vaccine.orElse(new Vaccine("Default","No",0));
    }

    @Override
    public List<Vaccine> searchVaccineByObject(Vaccine vaccine) {
        Example<Vaccine> example = Example.of(vaccine);
        return repo.findAll(example);
    }

    @Override
    public String removeVaccineInfo(Iterable<Integer> ids) {
        List<Vaccine> vaccine = repo.findAllById(ids);
        ArrayList<Integer> idsList = (ArrayList)ids;
        if(vaccine.size() == idsList.size()){
            repo.deleteAllById(ids);
            System.out.println("Vaccines with given id's are deleted.");
        }
        return "Vaccines with given id's are not deleted";
    }
}
