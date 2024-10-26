package com.ge.api;

import com.ge.dto.UserDTO;
import com.ge.model.User;
import com.ge.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private IUserService service;

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @PostMapping("/createUser")
    @Operation(summary = "POST Operation", description = "API will accept json user info and return user object.")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        logger.info("Received request to create user: {}",userDTO);
        User user = service.createUser(userDTO.getUserName(),userDTO.getPassword(),userDTO.getRole(), userDTO.getEmail());
        UserDTO responseDTO = new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getRole());
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/getUser/{id}")
    @Operation(summary = "Get Operation", description = "API will accept userId and return user object.")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id){
        User user = service.getUser(id);
        UserDTO responseDTO = new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getRole(), user.getEmail());
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/updateUser")
    @Operation(summary = "Put Operation",description = "API will accept json user info and it will update.")
    public ResponseEntity<Void> updateUser(@RequestBody User user){
        logger.info("Received request to update the user: {}",user.getUsername());
        service.updateUser(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteUser")
    @Operation(summary = "Delete Operation", description = "API will accept userId and will delete the respective user.")
    public void deleteUser(@RequestParam Long userId){
        logger.info("Received request to delete the user: {}",userId);
        service.deleteUser(userId);
    }

    @GetMapping("/findAllUsers")
    @Operation(summary = "Get Operation", description = "API will find all the users stored in the database.")
    public List<User> findAllUsers(){
        return service.findAllUsers();
    }

    @GetMapping("/findByUsername")
    @Operation(summary = "Get Operation", description = "API will accept user name and will find the respective user.")
    public User findUserByUsername(@RequestParam String username){
        return service.findUserByUsername(username);
    }

    @PatchMapping("/assignRole/{userId}/{role}")
    @Operation(summary = "Patch Operation", description = "API will accept userId, role. It will assign user with that role.")
    public ResponseEntity<Void> assignRoleToUser(@PathVariable Long userId,@PathVariable String role){
        logger.info("Received request to assign the role to user: {}",userId);
        service.assignRoleToUser(userId,role);
        logger.info("Role changed to user {} successfully.",userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/authentication")
    @Operation(summary = "Get Operation", description = "API will accept user name and password and will authenticate them.")
    public ResponseEntity<Boolean> authenticateUser(@RequestParam String username, @RequestParam String password){
        logger.info("Received request to authenticate user: {}",username);
        Boolean status = service.authenticateUser(username,password);
        logger.info("Authenticated user {} successfully",username);
        return ResponseEntity.ok(status);
    }

}
