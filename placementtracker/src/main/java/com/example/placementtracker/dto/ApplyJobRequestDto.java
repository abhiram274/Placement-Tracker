package com.example.placementtracker.dto;

public class ApplyJobRequestDto {
    private Long jobId;

    // No-arg constructor
    public ApplyJobRequestDto() {
    }

    // Constructor with jobId
    public ApplyJobRequestDto(Long jobId) {
        this.jobId = jobId;
    }

    // Getter
    public Long getJobId() {
        return jobId;
    }

    // Setter
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
}