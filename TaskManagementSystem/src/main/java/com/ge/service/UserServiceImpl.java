package com.ge.service;

import com.ge.model.Task;
import com.ge.model.User;
import com.ge.repository.IUserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepo repo1;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /*
        Suggested Approach:
        Log CRUD Operations: These are often more prone to issues (validation, saving data, etc.), so logging them helps you troubleshoot and monitor changes.
        Skip Logs for find Methods: If no immediate issues are anticipated, you can avoid logging find methods to keep logs concise and focused on important actions.
        Add Logs Later as Needed: If you encounter problems in find methods, such as incorrect data retrieval or performance bottlenecks, you can introduce logs at that point to assist with debugging.
     */

    @Override
    public User createUser(String username, String password, String role, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        user.setEmail(email);
        try{
            User savedUser = repo1.save(user);
            logger.info("User created successfully with ID: {}", savedUser.getId());
            return savedUser;
        }
        catch(Exception e){
            logger.error("Error occurred while creating user: {]", e.getMessage());
            throw e;
        }
    }

    @Override
    public User getUser(Long id) {
       return repo1.findUserById(id);
    }

    @Override
    public void updateUser(User user) {
        logger.info("Updating user with ID: {}",user.getId());
        try{
            repo1.updateUser(user);
            logger.info("User updated successfully with ID: {}",user.getId());
        }
        catch(Exception e){
            logger.error("Error occurred while updating user: {}",user.getId());
            throw e;
        }
    }

    @Override
    public void deleteUser(Long userId) {
        logger.info("Deleting task with ID: {}",userId);
        try{
            repo1.deleteUser(userId);
            logger.info("Task deleted successfully with ID: {}",userId);
        }
        catch(Exception e){
            logger.error("Error occurred while deleting task: {}",userId);
            throw e;
        }
    }

    @Override
    public List<User> findAllUsers() {
        return repo1.findAll();
    }

    @Override
    public User findUserByUsername(String username) {
        return repo1.findUserByUsername(username);
    }

    @Override
    public void assignRoleToUser(Long userId, String role) {
        repo1.assignRoleToUser(userId,role);
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        User user = repo1.findUserByUsername(username);
        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
