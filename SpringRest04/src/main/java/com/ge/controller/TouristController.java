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
        try{
            String message = service.registerTourist(tourist);
            return new ResponseEntity<String>(message,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<String>("Some problem in enrolling tourist", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> fetchAllTourists(){
        try{
            List<Tourist> list = service.fetchAllTourists();
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Some problem in fetching Tourist Info", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> fetchTourist(@PathVariable("id") Integer id){
        try{
            Tourist tourist = service.fetchTouristInfoById(id);
            return new ResponseEntity<>(tourist, HttpStatus.OK);
        }
        catch(TouristNotFoundException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateTouristInfo(@RequestBody Tourist tourist){
        try{
            String msg = service.updateTouristInfo(tourist);
            return new ResponseEntity<String>(msg,HttpStatus.OK);
        }
        catch(TouristNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/updateBudget/{id}/{budget}")
    public ResponseEntity<String> updateTouristInfo(@PathVariable("id") Integer id,@PathVariable("budget") Double budget){
        try{
            String msg = service.updateTouristInfoById(id,budget);
            return new ResponseEntity<String>(msg,HttpStatus.OK);
        }
        catch(TouristNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTouristInfo(@PathVariable("id") Integer id){
        try{
            String msg = service.deleteTouristById(id);
            return new ResponseEntity<String>(msg,HttpStatus.OK);
        }
        catch(TouristNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }



}
