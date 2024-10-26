package com.ge.controller;

import com.ge.model.Passenger;
import com.ge.model.Ticket;
import com.ge.service.ITicketBookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/book-ticket")
@Tag(name = "TicketBookingAPI's",description = "API's to book the ticket and get the ticket details.")
public class TicketBookingRestController {

    @Autowired
    private ITicketBookingService service;

    @PostMapping("/getTicketNumber")
    @Operation(summary = "POST Operation",description = "API will accept json passenger info and will return ticket object.")
    public ResponseEntity<Ticket> registerPassenger(@RequestBody Passenger passenger1){
        Passenger passenger2 = service.registerPassenger(passenger1);
        Ticket ticket = new Ticket();
        ticket.setTicketNumber(passenger2.getPid());
        return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
    }

    @GetMapping("/getTicket/{ticketNumber}")
    @Operation(summary = "GET Operation",description = "API will accept ticket number and will return ticket info.")
    public ResponseEntity<Ticket> getMyFullTicket(@PathVariable("ticketNumber") Integer ticketNumber){
        Passenger passenger = service.fetchPassengerInfo(ticketNumber);
        Ticket ticket = new Ticket();
        ticket.setStatus("Confirmed");
        ticket.setTicketCost(50000.00);
        ticket.setName(passenger.getName());
        ticket.setArrival(passenger.getArrival());
        ticket.setDeparture(passenger.getDeparture());
        ticket.setDateOfJourney(passenger.getDateOfJourney());
        ticket.setTicketNumber(passenger.getPid());
        return new ResponseEntity<Ticket>(ticket,HttpStatus.OK);
    }
}
