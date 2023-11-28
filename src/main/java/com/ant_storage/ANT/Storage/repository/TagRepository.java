package com.ant_storage.ANT.Storage.repository;

import com.ant_storage.ANT.Storage.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer>{
	List<Tag> findByUsername(String username);
}
