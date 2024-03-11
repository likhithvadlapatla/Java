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

        service.fetchByVaccineCompanyName("Astrazenica").forEach(v->System.out.println(v));
        System.out.println("*******************************************************************************");
        service.fetchByVaccineCompanyName("Astrazenica","Bharat Bio").forEach(v->System.out.println(v));
        System.out.println("*******************************************************************************");
        service.fetchByVaccinePriceRange(500,2500).forEach(v->System.out.println(v));
        System.out.println("*******************************************************************************");
        List<Object[]> vaccineInfo = service.fetchVaccineInfoByVaccineName("Covishield","Phizer");
        for(Object[] objects : vaccineInfo){
            for(Object vaccine : objects){
                System.out.print(vaccine+" ");
            }
            System.out.println();
        }
        System.out.println("*******************************************************************************");
        int rowsAffected1 = service.UpdatePriceByVaccineName(4545,"Covaxin");
        System.out.println("Number of records updated : "+rowsAffected1);
        System.out.println("*******************************************************************************");
        int rowsAffected2 = service.deleteVaccineByPriceRange(500,1500);
        System.out.println("Number of records deleted : "+rowsAffected2);
        System.out.println("*******************************************************************************");
        int rowsAffected3 = service.insertVaccineInfo(44,"Covaxin","Bharat Bio", 45454);
        System.out.println("Number of rows inserted :"+rowsAffected3);
    }
}
