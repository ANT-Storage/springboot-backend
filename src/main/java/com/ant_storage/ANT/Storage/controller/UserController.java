package com.ant_storage.ANT.Storage.controller;

import com.ant_storage.ANT.Storage.entity.LoginResponse;
import com.ant_storage.ANT.Storage.entity.User;
import com.ant_storage.ANT.Storage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("antstorage/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Integer id) {
        Optional<User> user = userService.getUserById(id);
        return (user.isPresent())?ResponseEntity.ok(user):ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public User createUser(User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
    	userService.deleteUser(id);
    }
    
    // Authentication
    @PostMapping("/login")
    @ResponseBody
    public LoginResponse login(String username, String password) {
        String status = "error";
        String message = "Invalid credentials";
        if(userService.userExists(username,password)) {
            status = "success";
            message = "Login successful";
        }
        return new LoginResponse(status,message);
    }

}

