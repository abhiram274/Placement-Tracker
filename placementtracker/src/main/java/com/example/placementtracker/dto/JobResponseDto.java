package com.example.placementtracker.dto;

public class JobResponseDto {
    private Long id;
    private String roleName;
    private String minYear;
    private String companyName;

    // Constructor
    public JobResponseDto(Long id,String roleName, String minYear, String companyName) {
        this.id = id;
        this.roleName = roleName;
        this.minYear = minYear;
        this.companyName = companyName;
    }

    // No-arg constructor
    public JobResponseDto() {
    }

    // Getters and setters
    public Long getId() {
        return id;
    }
    
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getMinYear() {
        return minYear;
    }

    public void setMinYear(String minYear) {
        this.minYear = minYear;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}