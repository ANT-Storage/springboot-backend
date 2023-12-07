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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String barcode;
    private String name;
    private String description;
    private String size;
    private String location;
    private String date;
    private Integer category_id;
    private Integer image_id;

    public Product(String barcode, String name, String description, String size, String location, String date, Integer category_id, Integer image_id) {
    	this.barcode = barcode;
        this.name = name;
        this.description = description;
        this.size = size;
        this.location = location;
        this.date = date;
        this.category_id = category_id;
        this.image_id = image_id;
    }
}
