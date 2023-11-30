package com.ant_storage.ANT.Storage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ant_storage.ANT.Storage.entity.CategoryProduct;
import com.ant_storage.ANT.Storage.service.CategoryProductService;


@RestController
@RequestMapping("antstorage/v1/category")
public class CategoryProductController {
	@Autowired
	private CategoryProductService categoryProductService;
	
	@GetMapping("/{id}/products")
	public List<CategoryProduct> getAllProductsByCategoryId(@PathVariable Integer id){
		return categoryProductService.getAllProductsWithCategory(id);
	}
}
