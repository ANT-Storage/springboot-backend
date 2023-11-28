package com.ant_storage.ANT.Storage.controller;

import com.ant_storage.ANT.Storage.entity.Product;
import com.ant_storage.ANT.Storage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("antstorage/v1")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllCategories(){
        return productService.findAllProducts();
    }

    @GetMapping("products/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Integer id) {
        Optional<Product> product = productService.getProductById(id);
        return (product.isPresent())?ResponseEntity.ok(product):ResponseEntity.notFound().build();
    }

    @PostMapping("/products")
    public Product createProduct(Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("products/{id}")
    public void deleteProduct(Integer id) {
        productService.deleteProduct(id);
    }

}
