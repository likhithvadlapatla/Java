package com.ge.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ge.dao")
@EntityScan(basePackages = "com.ge.model")
@ComponentScan(basePackages = "com.ge")
public class LaunchApplication {
	/*If you are getting same hashcode then the bean is created for only one time. i.e, in this application you are printing repo.hashcode() in two files, both of them will print same hashcode if you don't mention any other scope because singleton is the default scope.*/
	/*If your scope is prototype, for every dependency injection one bean will be created. Also, this follows lazy loading.*/
	/*If your scope is request, for every request the beans will be created. Also, this follows lazy loading.*/
	/*If your scope is session, for every session the beans will be created. Also, this follows lazy loading.*/

	public static void main(String[] args) {
		SpringApplication.run(LaunchApplication.class, args);
	}

}
