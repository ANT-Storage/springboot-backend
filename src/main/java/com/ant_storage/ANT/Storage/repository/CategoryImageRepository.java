package com.ant_storage.ANT.Storage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ant_storage.ANT.Storage.entity.CategoryImage;


public interface CategoryImageRepository extends JpaRepository<CategoryImage, Integer>{
	Optional<CategoryImage> findByName(String name);
}
