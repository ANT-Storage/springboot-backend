package com.ant_storage.ANT.Storage.controller;

import com.ant_storage.ANT.Storage.entity.User;
import com.ant_storage.ANT.Storage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("antstorage/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return (user.isPresent())?ResponseEntity.ok(user):ResponseEntity.notFound().build();
    }

}
