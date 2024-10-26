package com.ge.app;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaunchApplication {

	public static void main(String[] args) {
		/*Here you are creating your own instance of SpringApplication so that the default behaviour of SpringApplication.run(LaunchApplication.class, args) can be overridden.*/
		SpringApplication app = new SpringApplication(LaunchApplication.class);
		app.setBannerMode(Banner.Mode.CONSOLE);
		app.run(args);
	}

}
