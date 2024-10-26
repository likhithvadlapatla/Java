package com.ge.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class LaunchApplication {

	private static String GET_URL="http://localhost:8086/TicketBookingApp/api/book-ticket/getTicket/{ticketNumber}";
	public static void main(String[] args) {

		/*
		webClient.get() initiates a GET request.
		.uri(GET_URL, 2) sets the URI for the request. The 2 might be a parameter that gets substituted into GET_URL (e.g., if GET_URL contains a placeholder like /api/resource/{id}).
		.retrieve() sends the request and expects a response.
		.bodyToMono(String.class) indicates that the response body should be converted into a Mono<String>.
		The .subscribe(LaunchApplication::handleResponse) call subscribes to the Mono<String>. This means that when the API response is received, the handleResponse method is automatically called with the response body as its argument.
		 */
		SpringApplication.run(LaunchApplication.class, args);
		System.out.println("Request to API started.");
		WebClient webClient = WebClient.create();
		webClient.get()
				.uri(GET_URL, 2)
				.retrieve()
				.bodyToMono(String.class).subscribe(LaunchApplication::handleResponse);
		System.out.println("Request to API ended.");
	}

	public static void handleResponse(String ticket){
		System.out.println(ticket);
	}

}
