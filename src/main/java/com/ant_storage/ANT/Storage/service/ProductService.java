package com.ant_storage.ANT.Storage.service;

import com.ant_storage.ANT.Storage.entity.Product;
import com.ant_storage.ANT.Storage.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Integer id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setLocation(updatedProduct.getLocation());
        existingProduct.setDate(updatedProduct.getDate());
        existingProduct.setCategory_id(updatedProduct.getCategory_id());

        // Save the updated user
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }
        productRepository.deleteById(id);
    }
}