package com.ant_storage.ANT.Storage.controller;

import com.ant_storage.ANT.Storage.entity.Product;
import com.ant_storage.ANT.Storage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

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
    public Product createProduct(Product product, @RequestParam("file") MultipartFile image) {
    	
    	if(!image.isEmpty()) {
    		Path imageDirectory = Paths.get("src//main//resources//static/images");
    		String absoluteRoute = imageDirectory.toFile().getAbsolutePath();
    		
    		try {
				byte[] bytesImg = image.getBytes();
				Path fullRout = Paths.get(absoluteRoute + "//" + image.getOriginalFilename());
				Files.write(fullRout, bytesImg);
				
				product.setUrl_img(imageDirectory+"//"+image.getOriginalFilename());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
    		
    	}
    	
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, Product product) {
        return productService.updateProduct(id, product);
    }
    
    @GetMapping("/image/{id}")
    public String getImage(@PathVariable Integer id) {
    	return productService.getImage(id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

}
