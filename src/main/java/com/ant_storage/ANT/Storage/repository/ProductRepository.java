package com.ant_storage.ANT.Storage.repository;

import com.ant_storage.ANT.Storage.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);
    Optional<Product> findByBarcode(String barcode);
}
