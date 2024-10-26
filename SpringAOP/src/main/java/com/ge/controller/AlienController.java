package com.ge.controller;

import com.ge.dao.Alien;
import com.ge.service.IAlienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlienController {

    @Autowired
    private IAlienService service;

    @PostMapping("/register")
    public ResponseEntity<Alien> registerAlien(@RequestBody Alien alien) throws Exception {
        Alien al = service.registerAlienInfo(alien);
        return new ResponseEntity<Alien>(al, HttpStatus.CREATED);
    }

    @GetMapping("/fetch")
    public ResponseEntity<List> fetchAliens(){
        List<Alien> list = service.getAllAlienInfo();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }


}
