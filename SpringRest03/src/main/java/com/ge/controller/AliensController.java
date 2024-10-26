package com.ge.controller;

import com.ge.model.Alien;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api3")
public class AliensController {

    /*This method sends the data from the application to the form.*/
    @GetMapping("/getalien")
    public ResponseEntity<Alien> getResponse(){
        Alien alien = new Alien();
        alien.setId(2);
        alien.setName("Triveni");
        alien.setCity("Eluru");
        return new ResponseEntity<Alien>(alien, HttpStatus.OK);
    }

    /*This method gets the data from the form.*/
    /*@RequestBody annotation will bring the JSON data to the API method.*/
    @PostMapping("/save")
    public ResponseEntity<String> saveData(@RequestBody Alien alien){
        System.out.println(alien);
        String status = "Data Stored Successfully";
        return new ResponseEntity<String>(status, HttpStatus.OK);
    }
}
