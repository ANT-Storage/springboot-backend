package com.ant_storage.ANT.Storage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ant_storage.ANT.Storage.entity.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {
    Optional<ProductImage> findByBarcode(String barcode);
}
