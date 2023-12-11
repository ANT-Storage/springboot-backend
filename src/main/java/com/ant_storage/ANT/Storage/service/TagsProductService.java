package com.ant_storage.ANT.Storage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ant_storage.ANT.Storage.entity.TagsProduct;
import com.ant_storage.ANT.Storage.repository.TagsProductRepository;

@Service
public class TagsProductService {
	@Autowired
	private TagsProductRepository tagsProductRepository;
	
	public List<TagsProduct> findAllTagsProducts() {
		return tagsProductRepository.findAll();
	}
	
	public TagsProduct saveTagsProduct(TagsProduct tagsProduct) {
		return tagsProductRepository.save(tagsProduct);
	}
	
	public void deleteTagsProduct(Integer id) {
		tagsProductRepository.deleteById(id);
	}
}
