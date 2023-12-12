package com.ant_storage.ANT.Storage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ant_storage.ANT.Storage.entity.ProductTagDTO;
import com.ant_storage.ANT.Storage.service.ProductTagDTOService;

@RestController
@RequestMapping("antstorage/v1/get_products")
public class ProductTagDTOController {
	@Autowired
	private ProductTagDTOService productTagDTOService;
	
	@GetMapping
	public List<ProductTagDTO> getAllProductTagDTO(){
		return productTagDTOService.getAllProductTag();
	}
}
