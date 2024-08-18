package com.narcis.amazing_spring.data.entity;

import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
public class Coffee {
    private String id;
    private String name;

    public Coffee(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Coffee(String name) {
        this(UUID.randomUUID().toString(), name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
