package com.ant_storage.ANT.Storage.service;

import com.ant_storage.ANT.Storage.entity.Product;
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

	public Product saveProduct(Product product, @RequestParam("file") MultipartFile image) {
		if (!image.isEmpty()) {
			Path imageDirectory = Paths.get("src//main//resources//static/images");
			String absoluteRoute = imageDirectory.toFile().getAbsolutePath();

			try {
				byte[] bytesImg = image.getBytes();
				Path fullRout = Paths.get(absoluteRoute + "//" + image.getOriginalFilename());
				Files.write(fullRout, bytesImg);

				product.setUrl_img(imageDirectory + "//" + image.getOriginalFilename());

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
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

	public ResponseEntity<byte[]> getImage(Integer id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

		byte[] imageContent = null;
		try {
			Path imagePath = Paths.get(product.getUrl_img());
			imageContent = Files.readAllBytes(imagePath);
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG); // Set the appropriate media type for your image

		return new ResponseEntity<>(imageContent, headers, HttpStatus.OK);
	}
}