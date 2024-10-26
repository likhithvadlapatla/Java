package com.ge.rest;

import com.ge.model.Users;
import com.ge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    /*
    encoder.encode(user.getPassword()) uses the BCryptPasswordEncoder (configured with strength 12) to hash the plain text password.
     */
    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return service.saveTheUser(user);
    }
}
