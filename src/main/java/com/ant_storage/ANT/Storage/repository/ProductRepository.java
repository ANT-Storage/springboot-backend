package com.ant_storage.ANT.Storage.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ant_storage.ANT.Storage.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);
//    List<Product> findByCategory_id(Integer category_id);
    Optional<Product> findByBarcode(String barcode);
}

