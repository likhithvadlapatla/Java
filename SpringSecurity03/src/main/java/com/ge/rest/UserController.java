package com.ge.rest;

import com.ge.model.Users;
import com.ge.service.JwtService;
import com.ge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    /*
    encoder.encode(user.getPassword()) uses the BCryptPasswordEncoder (configured with strength 12) to hash the plain text password.
     */
    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return service.saveTheUser(user);
    }

    /*
        AuthenticationManager.authenticate(...):
        When you call authenticationManager.authenticate(...), it attempts to authenticate the user based on the provided credentials (e.g., username and password).
        This method returns an Authentication object that contains the authentication result, including whether the user was successfully authenticated.

        authentication.isAuthenticated():
        Even though AuthenticationManager.authenticate(...) usually throws an exception if authentication fails, it's still good practice to check authentication.isAuthenticated() to confirm that the authentication was indeed successful.
        This check allows your code to handle cases where the authentication might be partially successful or when you're using a custom AuthenticationProvider that might not throw an exception but instead return an Authentication object with isAuthenticated() set to false.

        If you use a custom AuthenticationProvider or have complex authentication logic, the authenticate method might not always throw an exception for every failure. Instead, it might return an Authentication object with isAuthenticated() set to false. This allows the method to provide more nuanced responses, depending on the situation.
     */

    public String login(@RequestBody Users user){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword()));

        if(authentication.isAuthenticated()){
            return null;
        }
        else{
            return "Login Failed";
        }
    }
}
