package com.ant_storage.ANT.Storage.repository;

import com.ant_storage.ANT.Storage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByUsername(String username);
}
