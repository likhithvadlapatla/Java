package com.ge.service;

import com.ge.model.Passenger;
import com.ge.model.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookingTicketService implements IBookingTicketService{

    /*
    booking_url: This is the URL endpoint for booking a ticket. The API at this URL is expected to handle a POST request with a Passenger object and return a Ticket object.
    get_url: This URL endpoint is for retrieving a ticket by its ticket number. The {ticketNumber} part is a path variable, meaning the actual ticket number will be substituted here when making the request.
     */

    private String booking_url = "http://localhost:8086/api/book-ticket/getTicketNumber";
    private String get_url = "http://localhost:8086/api/book-ticket/getTicket/{ticketNumber}";

    /*
    RestTemplate:
    RestTemplate is a Spring class that simplifies making HTTP requests. It can handle various types of HTTP methods like GET, POST, PUT, DELETE, etc.

    postForEntity Method:
    restTemplate.postForEntity(booking_url, passenger, Ticket.class) sends a POST request to the booking_url.

    Parameters:
    booking_url: The URL where the request is sent.
    passenger: The Passenger object that is sent as the request body. This object contains the details of the passenger that are needed to book the ticket.
    Ticket.class: This specifies the expected response type, which in this case is a Ticket object.
    Response:
    The postForEntity method returns a ResponseEntity<Ticket>, which contains the HTTP response, including the body, headers, and status code.
    Extracting the Response Body:

    responseEntity.getBody(): This extracts the Ticket object from the response body.

    Return:
    The method returns the Ticket object obtained from the response. This object will contain the details of the ticket that was booked.
    */

    @Override
    public Ticket bookTicket(Passenger passenger) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Ticket> responseEntity = restTemplate.postForEntity(booking_url,passenger, Ticket.class);
        return responseEntity.getBody();
    }

    /*
    getForObject Method:

    restTemplate.getForObject(get_url, Ticket.class, ticketNumber) sends an HTTP GET request to the specified get_url and expects a response that can be mapped to a Ticket object.
    Parameters:

    get_url: The URL template for the GET request. In this case, it's "http://localhost:8086/api/book-ticket/getTicket/{ticketNumber}". The {ticketNumber} in the URL is a placeholder for the actual ticket number.
    Ticket.class: The expected type of the response body, which is a Ticket object.
    ticketNumber: The actual ticket number that will replace {ticketNumber} in the get_url.
    How It Works:

    The ticketNumber is inserted into the get_url where {ticketNumber} is, forming the final URL (e.g., http://localhost:8086/api/book-ticket/getTicket/12345 if ticketNumber is 12345).
    A GET request is sent to this URL.
    The response body, which should contain the ticket information, is deserialized into a Ticket object and returned.
    */

    @Override
    public Ticket getFullTicketInfo(Integer ticketNumber) {
        RestTemplate restTemplate = new RestTemplate();
        Ticket ticket = restTemplate.getForObject(get_url, Ticket.class,ticketNumber);
        return ticket;
    }
}
