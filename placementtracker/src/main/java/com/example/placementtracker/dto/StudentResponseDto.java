package com.example.placementtracker.dto;

public class StudentResponseDto {

    private String fullName;
    private String branch;
    private Integer year;
    private Boolean eligible;

    public StudentResponseDto(String fullName, String branch, Integer year, Boolean eligible) {
        this.fullName = fullName;
        this.branch = branch;
        this.year = year;
        this.eligible = eligible;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBranch() {
        return branch;
    }

    public Integer getYear() {
        return year;
    }

    public Boolean getEligible() {
        return eligible;
    }
}
