package com.ge.service;

import com.ge.dao.ITicketRepo;
import com.ge.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope("prototype")
public class TicketBookingServiceImpl implements ITicketBookingService{

    @Autowired
    private ITicketRepo repo;

    @Autowired
    private TicketService service2;

    public TicketBookingServiceImpl(){
        System.out.println("Ticket Booking Service Bean Created");
    }
    @Override
    public Passenger registerPassenger(Passenger passenger) {
        return repo.save(passenger);
    }

    @Override
    public Passenger fetchPassengerInfo(Integer id) {
        service2.someMessage();
        System.out.println("Repo Hashcode : "+repo.hashCode());
        Optional<Passenger> optional = repo.findById(id);
        if(optional.isPresent())
            return optional.get();
        else{
            return new Passenger();
        }
    }
}
