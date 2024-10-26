package com.ge.service;

import com.ge.model.Passenger;
import com.ge.model.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BookingTicketService implements IBookingTicketService{

    /*
    booking_url: This is the URL endpoint for booking a ticket. The API at this URL is expected to handle a POST request with a Passenger object and return a Ticket object.
    get_url: This URL endpoint is for retrieving a ticket by its ticket number. The {ticketNumber} part is a path variable, meaning the actual ticket number will be substituted here when making the request.
     */

    private String booking_url = "http://localhost:8086/api/book-ticket/getTicketNumber";
    private String get_url = "http://localhost:8086/api/book-ticket/getTicket/{ticketNumber}";

    /*
    webClient.post():
    Starts building a POST request. This method is used to specify that the HTTP method for this request is POST.

    .uri(booking_url):
    Sets the URI (Uniform Resource Identifier) for the POST request. booking_url is the endpoint where the API is expecting to receive the request.

    .bodyValue(passenger):
    Sets the body of the request to be the passenger object. This will be sent as the request payload in the body of the POST request.

    .retrieve():
    Executes the request and prepares for the response. This step retrieves the response from the server.

    .bodyToMono(Ticket.class):
    Converts the response body into a Mono<Ticket>. A Mono is a reactive type that emits at most one item (in this case, a Ticket object).

    Synchronous Behavior: By calling .block(), you are effectively converting the non-blocking Mono into a blocking call, which is why this method behaves synchronously. It waits for the entire operation (sending the request and receiving the response) to complete before continuing.
     */

    @Override
    public Ticket bookTicket(Passenger passenger) {
        WebClient webClient = WebClient.create();
        Ticket ticket = webClient.post()
                .uri(booking_url)
                .bodyValue(passenger)
                .retrieve()
                .bodyToMono(Ticket.class)
                .block();
        return ticket;
    }

    /*
    webClient.get():
    Starts building a GET request. This method specifies that the HTTP method for this request is GET.

    .uri(get_url, ticketNumber):
    Sets the URI (Uniform Resource Identifier) for the GET request. get_url is the endpoint where the API is expecting to receive the request.
    The ticketNumber is used to replace the {ticketNumber} placeholder in the URL. For example, if get_url is "http://localhost:8086/api/book-ticket/getTicket/{ticketNumber}" and if ticketNumber is 12345, the final URL will be "http://localhost:8086/api/book-ticket/getTicket/12345".

    .retrieve():
    Initiates the request and prepares to handle the response.

    .bodyToMono(Ticket.class):
    Converts the response body into a Mono<Ticket>. Mono is a reactive type that emits at most one item. In this case, it's the Ticket object.
    */

    @Override
    public Ticket getFullTicketInfo(Integer ticketNumber) {
        WebClient webClient = WebClient.create();
        Ticket ticket = webClient.get()
                .uri(get_url, ticketNumber)
                .retrieve()
                .bodyToMono(Ticket.class)
                .block();
        return ticket;
    }
}
