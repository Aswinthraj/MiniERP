package com.raj.springweb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "business")   // 🔥 VERY IMPORTANT
public class Business {

    @Id
    private String id;

    private String name;
    private String owner;
    private String type;

    public Business(String name, String owner, String type) {
        this.name = name;
        this.owner = owner;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }
}