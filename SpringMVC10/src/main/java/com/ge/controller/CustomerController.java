package com.ge.controller;

import com.ge.model.Customer;
import com.ge.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {
    private ICustomerService service;

    @Autowired
    public void setService(ICustomerService service) {
        this.service = service;
    }

    @GetMapping("/cxlist")
    public String getCustomerData(Map<String, Object> map){
        List<Customer> customers = service.getCustomerInfo();
        System.out.println(customers);
        map.put("customers",customers);
        return "customerlist";
    }

    @GetMapping("/showform")
    public String getForm(){
        return "showform";
    }


}
