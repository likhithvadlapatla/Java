package com.ge.application;

import com.ge.beans.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Amazon {

    /*Field Injection*/
    /*This injection occurs when object is created*/
//  @Autowired
//  @Qualifier("blueDart")
    private DeliveryService service;

    static{
        System.out.println("Amazon class is loaded.");
    }

    Amazon(){
        System.out.println("Amazon bean is created.");
    }

    /*Constructor Injection*/
//    @Autowired
//    Amazon(@Qualifier("fedEx") DeliveryService service){
//        System.out.println("Injection through Constructor.");
//        this.service = service;
//    }

    Amazon(DeliveryService service){
        System.out.println("Injection through Constructor.");
        this.service = service;
    }

    /*Setter Injection*/
    @Autowired
    @Qualifier("dhl")
    public void setService(DeliveryService service){
        System.out.println("Injection through Setter.");
        this.service = service;
    }

    public Boolean deliverTheProduct(Double amount){
        return service.deliverProduct(amount);
    }
}

/*If there are three injections in the same class then Constructor Injection gets executed first, Field Injection gets executed next and at last Setter Injection gets executed.*/
