package com.ant_storage.ANT.Storage.repository;

import com.ant_storage.ANT.Storage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
