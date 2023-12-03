package com.ant_storage.ANT.Storage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ant_storage.ANT.Storage.entity.ProductImage;
import com.ant_storage.ANT.Storage.repository.ProductImageRepository;

@Service
public class ProductImageService {
	@Autowired
	private ProductImageRepository productImageRepository;
	
	public ProductImage saveProductImage(ProductImage productImage) {
		return productImageRepository.save(productImage);
	}
}
