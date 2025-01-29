package org.edusync.tutor.dto;

public class BookRequest {
    private String name;
    private String number;
    private String category;

    // Constructor
    public BookRequest() {
    }

    public BookRequest(String name, String number, String category) {
        this.name = name;
        this.number = number;
        this.category = category;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
} 