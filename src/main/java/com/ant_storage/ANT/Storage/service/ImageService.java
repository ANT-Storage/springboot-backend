package com.ant_storage.ANT.Storage.service;

import com.ant_storage.ANT.Storage.entity.Image;
import com.ant_storage.ANT.Storage.repository.ImageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;


@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    private final String defaultImagePath = "src//main//resources//static//images";

    public Optional<Image> getImageById(Integer id) {
        return imageRepository.findById(id);
    }

    public Image updateImage(Integer id, MultipartFile updatedImage) {
    	Image existingImage = imageRepository.findById(id)
    			.orElseThrow();
    	if(!updatedImage.isEmpty()) {
            Path imageDir = Paths.get(defaultImagePath);
            String absoluteRoute = imageDir.toFile().getAbsolutePath();

            try {
                byte[] imageContent = updatedImage.getBytes();
                Path fullRoute = Paths.get(absoluteRoute + "//" + updatedImage.getOriginalFilename());
                Files.write(fullRoute, imageContent);
                existingImage.setName(updatedImage.getOriginalFilename());
                existingImage.setPublic_url("localhost:8080/antstorage/v1/images/" + updatedImage.getOriginalFilename());
                existingImage.setStorage_url(imageDir + "//" + updatedImage.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    	
    	return imageRepository.save(existingImage);
    }
    
    public Image saveImage(MultipartFile image) {
        return imageRepository.save(generateImage(image));
    }

    public Image generateImage(MultipartFile image) {
        Image newImage = new Image();

        if(!image.isEmpty()) {
            Path imageDir = Paths.get(defaultImagePath);
            String absoluteRoute = imageDir.toFile().getAbsolutePath();

            try {
                byte[] imageContent = image.getBytes();
                Path fullRoute = Paths.get(absoluteRoute + "//" + image.getOriginalFilename());
                Files.write(fullRoute, imageContent);
                newImage.setName(image.getOriginalFilename());
                newImage.setPublic_url("localhost:8080/antstorage/v1/images/" + image.getOriginalFilename());
                newImage.setStorage_url(imageDir + "//" + image.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return newImage;
    }

    public ResponseEntity<byte[]> getImageData(Integer id) {
        Image foundImage = imageRepository.findById(id).orElseThrow();
        byte[] imageContent = null;
        try {
            Path imagePath = Paths.get(foundImage.getStorage_url());
            imageContent = Files.readAllBytes(imagePath);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(imageContent, headers, HttpStatus.OK);
    }

    public void deleteAllImages() {
    	List<Image> images = imageRepository.findAll();
    	imageRepository.deleteAll(images);
    }
}
