package com.ant_storage.ANT.Storage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ant_storage.ANT.Storage.entity.Product;
import com.ant_storage.ANT.Storage.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

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
		if(!updatedProduct.getBarcode().isBlank()) {
			existingProduct.setBarcode(updatedProduct.getBarcode());
		}
		if (!updatedProduct.getName().isBlank()) {
			existingProduct.setName(updatedProduct.getName());
		}
		if (!updatedProduct.getDescription().isBlank()) {
			existingProduct.setDescription(updatedProduct.getDescription());
		}
		if (!updatedProduct.getSize().isBlank()) {
			existingProduct.setSize(updatedProduct.getSize());
		}
		if (!updatedProduct.getLocation().isBlank()) {
			existingProduct.setLocation(updatedProduct.getLocation());
		}
		if (!updatedProduct.getDate().isBlank() && updatedProduct.getDate().length() == 10) {
			existingProduct.setDate(updatedProduct.getDate());
		}
		if (updatedProduct.getImage_id() instanceof Integer && updatedProduct.getImage_id() != null) {
			existingProduct.setImage_id(updatedProduct.getImage_id());
		}

		return productRepository.save(existingProduct);
	}

	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}

	public boolean deleteAllProductsByCategoryId(Integer category_id) {
		List<Product> products = productRepository.findAll().stream()
				.filter(product -> product.getCategory_id().equals(category_id)).toList();
		productRepository.deleteAll(products);
		return (productRepository.findAll().stream()
		.filter(product -> product.getCategory_id().equals(category_id)).count() == 0)?true:false;
	}
}