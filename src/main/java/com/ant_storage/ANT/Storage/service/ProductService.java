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
        if (!updatedProduct.getName().isBlank()) {
            existingProduct.setName(updatedProduct.getName());
        }
        if (!updatedProduct.getDescription().isBlank()) {
            existingProduct.setDescription(updatedProduct.getDescription());
        }
        if (!updatedProduct.getLocation().isBlank()) {
            existingProduct.setLocation(updatedProduct.getLocation());
        }
        if (!updatedProduct.getDate().isBlank() && updatedProduct.getDate().length() == 10) {
            existingProduct.setDate(updatedProduct.getDate());
        }
        if (updatedProduct.getCategory_id() != null) {
            existingProduct.setCategory_id(updatedProduct.getCategory_id());
        }
        if (!updatedProduct.getUrl_img().isBlank()) {
            existingProduct.setUrl_img(updatedProduct.getUrl_img());
        }

        // Save the updated user
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }
        productRepository.deleteById(id);
    }

    public String getImage(Integer id) {
    	Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));    	
    	
    	return product.getUrl_img();
    }
}