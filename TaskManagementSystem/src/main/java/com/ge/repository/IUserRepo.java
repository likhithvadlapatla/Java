package com.ge.repository;
import com.ge.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {
    public User findUserById(Long id);

    /*
        #{}: This is the SpEL syntax that allows you to evaluate an expression. It's used to inject values into the query dynamically.
        #user: The # before user is a SpEL syntax for referring to a method parameter (in this case, the User object passed to the method).
        #user.field: This accesses the field property of the user object.
        The + symbol in the @Query annotation is used to concatenate strings in Java. This is often done to make long query strings more readable by breaking them into multiple lines.
     */
    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.username=:#{#user.username}, "+
            "u.password=:#{#user.password}, "+
            "u.role=:#{#user.role}, "+
            "u.email=:#{#user.email}, "+
            "u.createdAt=:#{#user.createdAt}, "+
            "u.updatedAt=:#{#user.updatedAt} "+
            "WHERE u.id=:#{#user.id}"
            )
    public void updateUser(User user);

    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:userId")
    public void deleteUser(Long userId);

    public User findUserByUsername(String username);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.role=:role WHERE u.id=:userId")
    public void assignRoleToUser(Long userId, String role);

}
