package com.example.placementtracker.dto;

import jakarta.validation.constraints.NotBlank;

public class SkillRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String level;

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }
}
