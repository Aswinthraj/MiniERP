package com.raj.springweb.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

public class BusinessRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String owner;
    @NotBlank
    private String type;
    public String getName(){
        return name;
    }
    public String getOwner(){
        return owner;
    }
    public String getType(){
        return type;
    }
}
