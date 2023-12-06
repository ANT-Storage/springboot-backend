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
public class Configuration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String language;
    private String available_hours;
    private Integer image_id;
    
    public Configuration(String name, String language, String available_hours, Integer image_id) {
    	this.name = name;
    	this.language = language;
    	this.available_hours = available_hours;
    	this.image_id = image_id;
    }
}
