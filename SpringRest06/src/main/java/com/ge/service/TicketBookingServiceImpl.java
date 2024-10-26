package com.ge.service;

import com.ge.dao.ITicketRepo;
import com.ge.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketBookingServiceImpl implements ITicketBookingService{

    @Autowired
    private ITicketRepo repo;
    @Override
    public Passenger registerPassenger(Passenger passenger) {
            return repo.save(passenger);
    }

    @Override
    public Passenger fetchPassengerInfo(Integer id) {
        Optional<Passenger> optional = repo.findById(id);
        if(optional.isPresent())
            return optional.get();
        else{
            return new Passenger();
        }
    }
}
