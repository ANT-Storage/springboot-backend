package com.ant_storage.ANT.Storage.service;

import com.ant_storage.ANT.Storage.entity.Category;
import com.ant_storage.ANT.Storage.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }

    public Category saveCategory(Category category) {
		return categoryRepository.save(category);
    }

    public void deleteCategory(Integer id) {
		categoryRepository.deleteById(id);
    }

}
