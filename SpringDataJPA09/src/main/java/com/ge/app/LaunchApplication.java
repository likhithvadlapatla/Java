package com.ge.app;

import com.ge.dao.CustomerInfo;
import com.ge.service.CustomerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ge.dao")
@EntityScan(basePackages = "com.ge.dao")
@ComponentScan(basePackages = "com.ge")
public class LaunchApplication {
    public static void main(String[] args){
        ConfigurableApplicationContext container = SpringApplication.run(LaunchApplication.class, args);
        CustomerServiceImpl service = container.getBean(CustomerServiceImpl.class);

//        CustomerInfo cx = new CustomerInfo(1, "Likhith","Eluru", LocalDateTime.of(2000,5,31,5,40), LocalTime.of(6,40), LocalDate.now());
//        String message = service.registerCustomer(cx);
//        System.out.println(message);

        service.fetchAllCxInfo().forEach(v->System.out.println(v));



    }
}
