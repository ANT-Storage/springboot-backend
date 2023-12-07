package com.ant_storage.ANT.Storage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ant_storage.ANT.Storage.entity.Product;
import com.ant_storage.ANT.Storage.service.ProductService;

@RestController
@RequestMapping("antstorage/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllCategories(){
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Integer id) {
        Optional<Product> product = productService.getProductById(id);
        return (product.isPresent())?ResponseEntity.ok(product):ResponseEntity.notFound().build();
    }

    @PostMapping
    public Product saveProduct(Product product) {
        return productService.saveProduct(product);
    }    
    
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }
    
	@DeleteMapping("/delete/{category_id}")
	public ResponseEntity<?> findProductsById(@PathVariable Integer category_id) {
		return productService.deleteAllProductsByCategoryId(category_id)?
				ResponseEntity.ok("Category items deleted!"):ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
	}

}
