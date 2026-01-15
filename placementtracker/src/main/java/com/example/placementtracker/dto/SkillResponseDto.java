package com.example.placementtracker.dto;

public class SkillResponseDto {

    private String name;
    private String level;

    public SkillResponseDto(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }
}
