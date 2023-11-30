package com.ant_storage.ANT.Storage.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String role;
    private String lastConnection;

    public User(String username, String password, String role, String lastConnection) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.lastConnection = lastConnection;
    }
}
