package com.raj.springweb.dto;

public class BusinessResponse {
    private String message;
    private String name;
    public BusinessResponse(String message,String name){
        this.message=message;
        this.name=name;
    }
    public String getMessage() {
        return message;
    }
    public String getName() {
        return name;
    }
}
