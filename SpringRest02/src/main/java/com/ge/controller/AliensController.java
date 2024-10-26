package com.ge.controller;

import com.ge.model.Alien;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2")
public class AliensController {

    @GetMapping("/getalien")
    public Alien getResponse(){
        Alien alien = new Alien();
        alien.setId(1);
        alien.setName("Likhith");
        alien.setCity("Eluru");
        return alien;
    }
}
