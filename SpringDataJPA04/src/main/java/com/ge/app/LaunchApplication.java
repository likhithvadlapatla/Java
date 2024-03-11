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

//        Vaccine vaccine = new Vaccine("Covaxin","Bharat Bio",945);
//        List<Vaccine> vaccineList = service.searchByGivenVaccineInfo(vaccine,true,"vaccineCompany");
//        vaccineList.forEach((e)->System.out.println(e));

//        Vaccine vaccine = service.searchVaccineById(1);
//        System.out.println(vaccine);

//        Vaccine vaccine = new Vaccine("Covishield","Astrazenica",999);
//        service.searchVaccineByObject(vaccine).forEach((e)->System.out.println(e));

        List<Integer> idsList = new ArrayList<>();
        idsList.add(4);
        service.removeVaccineInfo(idsList);


    }
}