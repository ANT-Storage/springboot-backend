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
    private String name;
    private String description;
    private String location;
    private String date;
    private String url_img;
    private Integer idCategory;

    // Constructor, getters y setters

    public CategoryProduct(Integer id, String name, String description, String location, String date, String url_img, Integer idCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
        this.url_img = url_img;
        this.idCategory = idCategory;
    }
}
