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
public class ProductTagDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String barcode;
    private String productName;
    private String description;
    private String size;
    private String location;
    private String date;
    private Integer categoryId;
    private Integer imageId;
    private Integer productId;
    private String tagName;

    public ProductTagDTO(Integer id, String barcode, String productName, String description, String size, String location,
                         String date, Integer categoryId, Integer imageId, Integer productId,
                         String tagName) {
        this.id = id;
        this.barcode = barcode;
        this.productName = productName;
        this.description = description;
        this.size = size;
        this.location = location;
        this.date = date;
        this.categoryId = categoryId;
        this.imageId = imageId;
        this.productId = productId;
        this.tagName = tagName;
    }
}
