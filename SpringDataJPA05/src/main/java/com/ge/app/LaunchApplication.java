package com.ge.app;

import com.ge.dao.Vaccine;
import com.ge.service.VaccineServiceImpl;
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

//        service.fetchByCost(945).forEach(v->System.out.println(v));

//        service.fetchByVaccineCompany("Astrazenica").forEach(v->System.out.println(v));

//        service.fetchByVaccineCompanyIs("Astrazenica").forEach(v->System.out.println(v));

//        service.fetchByVaccineCompanyEquals("Astrazenica").forEach(v->System.out.println(v));

//        service.fetchByCostLessThan(5000).forEach(v->System.out.println(v));

//        service.fetchByCostBetween(500,1500).forEach(v->System.out.println(v));

        List<String> vaccineNames = new ArrayList<>();
        vaccineNames.add("Covaxin");
        vaccineNames.add("Sputnik");
        service.fetchByVaccineNameInAndCostBetween(vaccineNames,500,1500).forEach(v->System.out.println(v));

    }
}
