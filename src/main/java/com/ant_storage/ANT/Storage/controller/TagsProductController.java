package com.ant_storage.ANT.Storage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ant_storage.ANT.Storage.entity.TagsProduct;
import com.ant_storage.ANT.Storage.service.TagsProductService;

@RestController
@RequestMapping("antstorage/v1/tags_products")
public class TagsProductController {
	@Autowired
	private TagsProductService tagsProductService;
	
	@GetMapping
	public List<TagsProduct> findAllTagsProduct() {
		return tagsProductService.findAllTagsProducts();
	}
	
	@PostMapping
	public TagsProduct createTagsProduct(TagsProduct tagsProduct) {
		return tagsProductService.saveTagsProduct(tagsProduct);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTagsProduct(@PathVariable Integer id) {
		tagsProductService.deleteTagsProduct(id);
	}
}
