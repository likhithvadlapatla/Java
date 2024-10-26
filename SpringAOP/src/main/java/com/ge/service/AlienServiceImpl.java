package com.ge.service;

import com.ge.dao.Alien;
import com.ge.dao.AlienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlienServiceImpl implements IAlienService{

    @Autowired
    private AlienRepo repo;
    @Override
    public Alien registerAlienInfo(Alien alien) throws Exception {
        String name = alien.getName();
        if(name.length()<=5){
            throw new Exception("Invalid name length exception.");
        }
        return repo.save(alien);
    }

    @Override
    public List<Alien> getAllAlienInfo() {
        return repo.findAll();
    }
}
