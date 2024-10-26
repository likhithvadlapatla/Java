package com.ge.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*You can access the swagger-ui at http://localhost:8086/swagger-ui/index.html.*/
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ge.dao")
@EntityScan(basePackages = "com.ge.model")
@ComponentScan(basePackages = "com.ge")
@OpenAPIDefinition(
		info = @Info(title="Ticket Booking API",
		version = "1.0",
		description = "This API is to book the ticket"),

		servers = @Server(
				url="http://localhost:8086",
				description = "This is server where our API is deployed")
)
public class LaunchApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaunchApplication.class, args);
	}

}
