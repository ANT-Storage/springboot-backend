package com.ant_storage.ANT.Storage.repository;

import com.ant_storage.ANT.Storage.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository  extends JpaRepository<Category,Integer> {
    List<Category> findByName(String name);
}
