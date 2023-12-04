package com.ant_storage.ANT.Storage.service;

import com.ant_storage.ANT.Storage.entity.Category;
import com.ant_storage.ANT.Storage.entity.CategoryImage;
import com.ant_storage.ANT.Storage.repository.CategoryImageRepository;
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
    
    @Autowired
    private CategoryImageRepository categoryImageRepository;

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }

    public Category saveCategory(Category category, @RequestParam("file") MultipartFile image) {
    	
    	if (!image.isEmpty()) {
			Path imageDirectory = Paths.get("src//main//resources//static/images");
			String absoluteRoute = imageDirectory.toFile().getAbsolutePath();

			try {
				byte[] bytesImg = image.getBytes();
				Path fullRout = Paths.get(absoluteRoute + "//" + image.getOriginalFilename());
				Files.write(fullRout, bytesImg);

				category.setUrl_img("localhost:8080/antstorage/v1/categories/image/" + category.getName());
							
				CategoryImage categoryImage = new CategoryImage();
				categoryImage.setName(category.getName());
				categoryImage.setUrl_img(imageDirectory + "//" + image.getOriginalFilename());
				categoryImageRepository.save(categoryImage);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	
    	
    	return categoryRepository.save(category);
    }

    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    public ResponseEntity<byte[]> getImage(String name){
	    CategoryImage categoryImage = categoryImageRepository.findByName(name)
	            .orElseThrow(() -> new EntityNotFoundException("Product image not found with name: " + name));

	    byte[] imageContent = null;
	    try {
	        Path imagePath = Paths.get(categoryImage.getUrl_img());
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
