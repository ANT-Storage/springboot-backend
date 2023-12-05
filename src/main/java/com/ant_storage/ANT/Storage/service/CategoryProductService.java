package com.ant_storage.ANT.Storage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ant_storage.ANT.Storage.entity.CategoryProduct;
import com.ant_storage.ANT.Storage.entity.Product;

@Service
public class CategoryProductService {

	@Autowired
	private final ProductService productService;

	public CategoryProductService(ProductService productService) {
		this.productService = productService;
	}

	public List<CategoryProduct> getAllProductsWithCategory(Integer categoryId) {
        List<Product> products = productService.findAllProducts();
        List<CategoryProduct> categoryProducts = new ArrayList<>();

        for (Product product : products) {
        	if(product.getCategory_id() == categoryId) {
        			CategoryProduct categoryProduct = new CategoryProduct(
                    product.getId(),
                    product.getBarcode(),
                    product.getName(),
                    product.getDescription(),
                    product.getLocation(),
                    product.getDate(),
 					product.getImage_id(),
                    product.getCategory_id()
            );
            categoryProducts.add(categoryProduct);
        	}
        }

        return categoryProducts;
    }



}
