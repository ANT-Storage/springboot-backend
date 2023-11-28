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

    private String name;
    private String description;
    private String location;
    private String date;
    private Integer category_id;

    public Product(String name, String description, String location, String date, Integer category_id) {
        this.description = description;
        this.location = location;
        this.date = date;
        this.category_id = category_id;
    }
}
