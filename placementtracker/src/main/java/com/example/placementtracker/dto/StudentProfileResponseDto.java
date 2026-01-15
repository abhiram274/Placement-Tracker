package com.example.placementtracker.dto;

public class StudentProfileResponseDto {
    private String fullName;
    private String email;
    private String branch;
    private int year;

    public StudentProfileResponseDto(String fullName, String email, String branch, int year) {
        this.fullName = fullName;
        this.email = email;
        this.branch = branch;
        this.year = year;
    }
    public String getFullName() {
        return fullName;
    }
    public String getEmail() {
        return email;
    }
    public String getBranch() {
        return branch;
    }
    public int getYear() {
        return year;
    }
    
}