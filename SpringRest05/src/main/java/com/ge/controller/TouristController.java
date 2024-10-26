package com.ge.controller;

import com.ge.exception.TouristNotFoundException;
import com.ge.model.Tourist;
import com.ge.service.ITouristManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TouristController {

    @Autowired
    private ITouristManagement service;

    @PostMapping("/register")
    public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist){
            String message = service.registerTourist(tourist);
            return new ResponseEntity<String>(message,HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> fetchAllTourists(){
            List<Tourist> list = service.fetchAllTourists();
            return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> fetchTourist(@PathVariable("id") Integer id){
            Tourist tourist = service.fetchTouristInfoById(id);
            return new ResponseEntity<>(tourist, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateTouristInfo(@RequestBody Tourist tourist){
            String msg = service.updateTouristInfo(tourist);
            return new ResponseEntity<String>(msg,HttpStatus.OK);
    }

    @PatchMapping("/updateBudget/{id}/{budget}")
    public ResponseEntity<String> updateTouristInfo(@PathVariable("id") Integer id,@PathVariable("budget") Double budget){
            String msg = service.updateTouristInfoById(id,budget);
            return new ResponseEntity<String>(msg,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTouristInfo(@PathVariable("id") Integer id){
            String msg = service.deleteTouristById(id);
            return new ResponseEntity<String>(msg,HttpStatus.OK);
    }



}
