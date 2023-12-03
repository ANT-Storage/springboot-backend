package com.ant_storage.ANT.Storage.service;

import com.ant_storage.ANT.Storage.entity.Product;
import com.ant_storage.ANT.Storage.entity.ProductImage;
import com.ant_storage.ANT.Storage.repository.ProductImageRepository;
import com.ant_storage.ANT.Storage.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductImageRepository productImageRepository;
	
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> getProductById(Integer id) {
		return productRepository.findById(id);
	}

    public Product saveProduct(Product product, @RequestParam("file") MultipartFile image) {

        if (!image.isEmpty()) {
            Path imageDirectory = Paths.get("src//main//resources//static/images");
            String absoluteRoute = imageDirectory.toFile().getAbsolutePath();

            try {
                byte[] bytesImg = image.getBytes();
                Path fullRout = Paths.get(absoluteRoute + "//" + image.getOriginalFilename());
                Files.write(fullRout, bytesImg);

                product.setUrl_img("localhost:8080/antstorage/v1/products/image/" + product.getBarcode());

                ProductImage productImage = new ProductImage();
                productImage.setBarcode(product.getBarcode());
                productImage.setUrl_img(imageDirectory + "//" + image.getOriginalFilename());
                productImageRepository.save(productImage);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        product.setDate(dateFormat.format(new Date()));

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

		return productRepository.save(existingProduct);
	}

	public void deleteProduct(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("ID must not be null");
		}
		productRepository.deleteById(id);
	}

	public ResponseEntity<byte[]> getImage(String barcode) {
	    ProductImage productImage = productImageRepository.findByBarcode(barcode)
	            .orElseThrow(() -> new EntityNotFoundException("Product image not found with barcode: " + barcode));

	    byte[] imageContent = null;
	    try {
	        Path imagePath = Paths.get(productImage.getUrl_img());
	        imageContent = Files.readAllBytes(imagePath);
	    } catch (IOException e) {
	        e.printStackTrace();
	        return ResponseEntity.notFound().build();
	    }

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_JPEG);

	    return new ResponseEntity<>(imageContent, headers, HttpStatus.OK);
	}


}