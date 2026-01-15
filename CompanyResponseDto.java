package com.example.placementtracker.dto;

public class CompanyResponseDto {
    private Long id;
    private String name;
    private String location;

    // No-arg constructor
    public CompanyResponseDto() {
    }

    // Constructor with all fields
    public CompanyResponseDto(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}