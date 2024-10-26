package com.ge.service;

import com.ge.model.Passenger;
import org.springframework.stereotype.Service;

@Service
public interface ITicketBookingService {
    public Passenger registerPassenger(Passenger passenger);
    public Passenger fetchPassengerInfo(Integer id);
}
