package com.example.placementtracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String companyName;

    private String roleName;
    private String minYear; // Changed to String to allow "2 years", "6 months", etc.
    private String description;

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getMinYear() {
        return minYear;
    }

    public String getDescription() {
        return description;
    }

    // ===== SETTERS =====
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setMinYear(String minYear) {
        this.minYear = minYear;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}