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
public class CategoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String barcode;
    private String name;
    private String description;
    private String location;
    private String date;
    private Integer category_id;
    private Integer image_id;

    public CategoryProduct(Integer id, String barcode, String name, String description, String location, String date, Integer image_id, Integer category_id) {
        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
        this.category_id = category_id;
        this.image_id = image_id;
    }
}
