package com.ge.service;

import com.ge.dao.UserRepo;
import com.ge.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
    This class is used in Spring Security to fetch user details during authentication. It implements the UserDetailsService interface, which is a core interface in Spring Security for retrieving user-related data.
*/
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    /*
    Separation of Concerns:
    Users Entity: Represents the user data in your database.
    UserPrincipal: Implements UserDetails, which Spring Security requires for authentication and authorization.
    Customization:

    UserPrincipal lets you control what is exposed to Spring Security. You might only want to expose the password and username, but keep other user-specific details hidden.
    */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByName(username);

        if(user == null){
            System.out.println("404 Not Found");
            throw new UsernameNotFoundException("404 User Not Found");
        }
        return new UserPrincipal(user);
    }
}
