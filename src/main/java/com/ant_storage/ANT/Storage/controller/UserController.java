package com.ant_storage.ANT.Storage.controller;

import com.ant_storage.ANT.Storage.entity.User;
import com.ant_storage.ANT.Storage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("antstorage/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping("/users")
    public User createUser(User user) {
        return userService.saveUser(user);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return (user.isPresent())?ResponseEntity.ok(user):ResponseEntity.notFound().build();
    }

    // Authentication
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> login(String username, String password) {
        String jsonString = "{\"status\": \"Wrong credentials\"}";
        if(userService.userExists(username,password)) {
            jsonString = "{\"status\": \"Success\"}";
        }
        return ResponseEntity.ok(jsonString);
    }

}

