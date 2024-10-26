package com.ge.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ge.repository")
@EntityScan(basePackages = "com.ge.model")
@ComponentScan(basePackages = "com.ge")
@OpenAPIDefinition(
		info = @Info(title="Task Management System",
		version = "1.0",
		description = "This project is designed to help users efficiently manage and track their tasks. It allows users to create, update, delete, and assign tasks, set deadlines, categorize tasks, and receive notifications for important deadlines. The system also includes user management, reporting, and security features."),

		servers = @Server(
				url = "http://localhost:8087",
				description = "This is the server where our API is deployed."
		)

)
public class LaunchApplication {
	public static void main(String[] args) {
		SpringApplication.run(LaunchApplication.class, args);
	}
}
