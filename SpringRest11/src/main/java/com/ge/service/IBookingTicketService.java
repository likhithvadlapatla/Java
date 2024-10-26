package com.ge.service;

import com.ge.model.Passenger;
import com.ge.model.Ticket;
import org.springframework.stereotype.Service;

@Service
public interface IBookingTicketService {
    public Ticket bookTicket(Passenger passenger);
    public Ticket getFullTicketInfo(Integer ticketNumber);
}
