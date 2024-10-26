package com.ge.service;

import com.ge.dao.ITouristRepo;
import com.ge.exception.TouristNotFoundException;
import com.ge.model.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristManagement implements ITouristManagement{

    @Autowired
    private ITouristRepo repo;
    @Override
    public String registerTourist(Tourist tourist) {
        Integer id = repo.save(tourist).getId();
        return "Tourist Information with an ID "+ id;

    }

    @Override
    public List<Tourist> fetchAllTourists() {
        return repo.findAll();
    }

    @Override
    public Tourist fetchTouristInfoById(Integer id) {
        Optional<Tourist> optional = repo.findById(id);
        if(optional.isPresent()){
            Tourist tourist = optional.get();
            return tourist;
        }
        else{
            return optional.orElseThrow(()-> new TouristNotFoundException("Tourist with given id "+id+" is not found"));
        }

    }

    @Override
    public String updateTouristInfo(Tourist tourist) {
        Integer id = tourist.getId();
        Optional<Tourist> optional = repo.findById(id);
        if(optional.isPresent()){
            repo.save(tourist);
            return "Tourist Info with id "+ id +" is updated";
        }
        else{
            throw new TouristNotFoundException("Tourist with given info is not found to update");
        }
    }

    @Override
    public String updateTouristInfoById(Integer id, Double budget) {
        Optional<Tourist> optional = repo.findById(id);
        if(optional.isPresent()){
            Tourist tourist = optional.get();
            tourist.setBudget(budget);
            repo.save(tourist);
            return "Tourist Info with id "+ id +" is updated";
        }
        else{
            throw new TouristNotFoundException("Tourist with given info is not found to update.");
        }
    }

    @Override
    public String deleteTouristById(Integer id) {
        Optional<Tourist> optional = repo.findById(id);
        if(optional.isPresent()){
            repo.deleteById(id);
            return "Tourist Info with id "+ id +" is deleted";
        }
        else{
            throw new TouristNotFoundException("Tourist with given info is not found to delete data.");
        }
    }
}
