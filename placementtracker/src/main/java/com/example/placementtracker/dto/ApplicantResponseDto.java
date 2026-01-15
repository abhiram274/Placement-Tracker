package com.example.placementtracker.dto;

public class ApplicantResponseDto {

    private Long applicationId;
    private String studentName;
    private String branch;
    private String status;

    public ApplicantResponseDto(Long applicationId, String studentName, String branch, String status) {
        this.applicationId = applicationId;
        this.studentName = studentName;
        this.branch = branch;
        this.status = status;
    }

    public Long getApplicationId() { return applicationId; }
    public String getStudentName() { return studentName; }
    public String getBranch() { return branch; }
    public String getStatus() { return status; }
}
