package com.ge.service;

import com.ge.model.Users;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public Users saveTheUser(Users user);
}
