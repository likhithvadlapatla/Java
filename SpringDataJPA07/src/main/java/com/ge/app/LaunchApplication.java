package com.ge.app;

import com.ge.dao.Vaccine;
import com.ge.service.VaccineServiceImpl;
import com.ge.view.ResultView1;
import com.ge.view.ResultView2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ge.dao")
@EntityScan(basePackages = "com.ge.dao")
@ComponentScan(basePackages = "com.ge")
public class LaunchApplication {
    public static void main(String[] args){
        ConfigurableApplicationContext container = SpringApplication.run(LaunchApplication.class, args);
        VaccineServiceImpl service = container.getBean(VaccineServiceImpl.class);

        service.fetchByCostLessThan(5000, ResultView1.class).forEach(v->System.out.println(v.getVaccineName()+" : "+v.getCost()));
        System.out.println("*******************************************************************************");
        service.fetchByCostLessThan(5000, ResultView2.class).forEach(v->System.out.println(v.getVaccineName()+" : "+v.getId()));
    }
}
