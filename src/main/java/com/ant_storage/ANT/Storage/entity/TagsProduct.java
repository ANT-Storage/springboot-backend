package com.ant_storage.ANT.Storage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class TagsProduct {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer tags_id;
	private Integer product_id;
	
	public TagsProduct(Integer tags_id, Integer product_id) {
		this.tags_id = tags_id;
		this.product_id = product_id;
	}
}
