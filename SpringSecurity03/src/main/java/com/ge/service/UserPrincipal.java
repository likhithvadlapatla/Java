package com.ge.service;

import com.ge.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {
    private Users users;

    public UserPrincipal(Users user){
        super();
        this.users = user;
    }

    /*
    What is GrantedAuthority?
    Interface for Authorities:

    GrantedAuthority is an interface that represents a single authority granted to an Authentication object.
    Authorities are often roles or permissions that a user can have.
    Typical Usage:

    You use GrantedAuthority to define what roles or permissions a user has.
    For example, roles like ADMIN, USER, or specific permissions can be represented by different GrantedAuthority implementations.
    */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getName();
    }
}
