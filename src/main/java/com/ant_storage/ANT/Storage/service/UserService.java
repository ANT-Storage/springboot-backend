package com.ant_storage.ANT.Storage.service;

import com.ant_storage.ANT.Storage.entity.User;
import com.ant_storage.ANT.Storage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Option

}
