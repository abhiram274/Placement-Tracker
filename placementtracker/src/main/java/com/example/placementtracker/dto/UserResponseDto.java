package com.example.placementtracker.dto;

public class UserResponseDto {

    private Long id;
    private String username;
    private String email;
    private boolean enabled;

    public UserResponseDto(Long id, String username, String email, boolean enabled) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
