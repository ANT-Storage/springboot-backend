package com.ant_storage.ANT.Storage.controller;

import com.ant_storage.ANT.Storage.entity.Category;
import com.ant_storage.ANT.Storage.entity.User;
import com.ant_storage.ANT.Storage.service.CategoryService;
import com.ant_storage.ANT.Storage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("antstorage/v1")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return categoryService.findAllCategories();
    }
}
