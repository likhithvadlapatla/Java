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
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ge.dao")
@EntityScan(basePackages = "com.ge.dao")
@ComponentScan(basePackages = "com.ge")
public class LaunchApplication {
    public static void main(String[] args){
        ConfigurableApplicationContext container = SpringApplication.run(LaunchApplication.class, args);
        VaccineServiceImpl service = container.getBean(VaccineServiceImpl.class);

//        Vaccine vaccine1 = new Vaccine("Covaxin","Bharat Bio",945);
//        String status1 = service.registerVaccineInfo(vaccine1);
//        System.out.println(status1);
//
//        Vaccine vaccine2 = new Vaccine("Covishield","Astrazenica",999);
//        Vaccine vaccine3 = new Vaccine("Phizer","USA",9994);
//        Vaccine vaccine4 = new Vaccine("Sputnik","Russia",4545);
//        List<Vaccine> vaccines = new ArrayList<Vaccine>();
//        vaccines.add(vaccine2);
//        vaccines.add(vaccine3);
//        vaccines.add(vaccine4);
//        service.registerMultipleVaccines(vaccines).forEach((e)->System.out.println(e));
//
//        Long vaccineCount = service.getVaccineCount();
//        System.out.println("Number of vaccines registered : "+vaccineCount);

//        Boolean status2 = service.checkAvailability(2);
//        if(status2 == true){
//            System.out.println("Vaccine with id 2 is available");
//        }
//        else{
//            System.out.println("Vaccine with id 2 is not available");
//        }

//        Iterable<Vaccine> vaccineList1 = service.getAllVaccinesInfo();
//        vaccineList1.forEach((e)->System.out.println(e));

//        List<Integer> idList = new ArrayList<>();
//        idList.add(1);
//        idList.add(2);
//        idList.add(3);
//        Iterable<Vaccine> vaccineList2 = service.getAllVaccinesInfoSpecific(idList);
//        vaccineList2.forEach((e)->System.out.println(e));

        /*Optional is a container object introduced in Java 8. It is used to represent the presence or absence of a value. It is a way to avoid null references and the problems associated with them, such as NullPointerException.*/
//        Optional<Vaccine> vaccine = service.getVaccineById(1);
//        if(vaccine!=null){
//            System.out.println(vaccine);
//        }
//        else{
//            System.out.println("Vaccine is not available.");
//        }

        /*The same method getVaccineById() can also be called like this.*/
        Optional<Vaccine> vaccine = service.getVaccineById(1);
        /*isPresent() method is used to check if the value is present.*/
        /*get() method retrieves the value if present, throws NoSuchElementException if not.*/
        if(vaccine.isPresent()){
            System.out.println(vaccine.get());
        }
        else{
            /*Returns the value if present, otherwise returns a default value.*/
            System.out.println(vaccine.orElse(new Vaccine()));
        }

//        System.out.println(service.removeVaccineById(53));

//        List<Integer> ids = new ArrayList<>();
//        ids.add(54);
//        ids.add(55);
//        System.out.println(service.removeVaccineByIds(ids));

        Vaccine vac = new Vaccine("Sputnik","Russia",4565);
        vac.setId(52);
        String s = service.removeVaccineUsingVaccineObj(vac);
        System.out.println(s);
    }
}
