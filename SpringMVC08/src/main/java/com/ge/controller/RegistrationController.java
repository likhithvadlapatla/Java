package com.ge.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String home(){
        return "register";
    }

    /*
    @ModelAttribute("impl1"): This annotation tells Spring to bind form data to an object of type Implementer. The "impl1" here is the name of the model attribute.

    Form Data Binding:
    The form data is added to an Implementer object using the key "impl1". This object is referred to as impl2 in your method.

    Storing in Model:
    The Implementer object (impl2) is then stored in the model with the key "impl3"*/
    @PostMapping("/register")
    public String register(Map<String, Object> model, @ModelAttribute("impl1")Implementer impl2){
        model.put("impl3",impl2);
        return "response";
    }
}
