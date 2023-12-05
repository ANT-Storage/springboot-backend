package com.ant_storage.ANT.Storage.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name="images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String storage_url;
    private String public_url;

    public Image(String name, String storage_url, String public_url) {
        this.name = name;
        this.storage_url = storage_url;
        this.public_url = public_url;
    }
}
