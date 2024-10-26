package com.ge.service;

import com.ge.dao.UserRepo;
import com.ge.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo repo;

    @Override
    public Users saveTheUser(Users user) {
        return repo.save(user);
    }
}
