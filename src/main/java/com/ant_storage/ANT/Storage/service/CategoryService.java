package com.ant_storage.ANT.Storage.service;

import com.ant_storage.ANT.Storage.entity.Category;
import com.ant_storage.ANT.Storage.repository.CategoryRepository;

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
        Optional<Category> optionalCategory = categoryRepository.findById(id);
		categoryRepository.deleteById(id);
    }

}
