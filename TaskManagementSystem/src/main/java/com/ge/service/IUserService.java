package com.ge.service;
import com.ge.model.Category;
import com.ge.model.Task;
import com.ge.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface IUserService {

    /*User Management*/
    User createUser(String username, String password, String role, String email);
    User getUser(Long id);
    void updateUser(User user);
    void deleteUser(Long userId);
    List<User> findAllUsers();
    User findUserByUsername(String username);
    void assignRoleToUser(Long userId, String role);
    boolean authenticateUser(String username, String password);
}
