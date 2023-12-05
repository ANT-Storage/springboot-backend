package com.ant_storage.ANT.Storage.repository;

import com.ant_storage.ANT.Storage.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Integer> {
}
