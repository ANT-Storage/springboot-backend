package com.ant_storage.ANT.Storage.controller;

import com.ant_storage.ANT.Storage.entity.Image;
import com.ant_storage.ANT.Storage.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("antstorage/v1/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Image>> getImageById(@PathVariable Integer id) {
        Optional<Image> image = imageService.getImageById(id);
        return (image.isPresent())?ResponseEntity.ok(image):ResponseEntity.notFound().build();
    }

    @GetMapping("/media/{id}")
    public ResponseEntity<byte[]> getImageMedia(@PathVariable Integer id) {
        return imageService.getImageData(id);
    }

    @PostMapping
    public Image createImage(@RequestParam("file") MultipartFile image) {
        return imageService.saveImage(image);
    }
    
    @PutMapping("/{id}")
    public Image updateImage(@RequestParam("id") Integer id, @RequestParam("file") MultipartFile image) {
        return imageService.updateImage(id, image);
    }

}
