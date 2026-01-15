package com.example.placementtracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StudentRequestDto {

    @NotBlank
    private String fullName;

    @NotBlank
    private String branch;

    @NotNull
    private Integer year;

    // getters & setters
    public String getFullName() {
        return fullName;
    }

    public String getBranch() {
        return branch;
    }

    public Integer getYear() {
        return year;
    }
}
