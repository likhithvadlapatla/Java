package com.ge.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ge")
public class LaunchApplication {

	public static void main(String[] args) {

		SpringApplication.run(LaunchApplication.class, args);
	}

}
