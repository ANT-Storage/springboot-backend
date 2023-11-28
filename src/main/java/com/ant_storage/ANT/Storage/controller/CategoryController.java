package com.ant_storage.ANT.Storage.controller;

import com.ant_storage.ANT.Storage.entity.Category;
import com.ant_storage.ANT.Storage.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("antstorage/v1/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping()
	public List<Category> getAllCategories() {
		return categoryService.findAllCategories();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable Integer id) {
		Optional<Category> category = categoryService.getCategoryById(id);
		return (category.isPresent()) ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public Category createCategory(Category category) {
		return categoryService.saveCategory(category);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Integer id) {
		categoryService.deleteCategory(id);
	}
	
}
