package com.example.placementtracker.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.placementtracker.dto.ApplicantResponseDto;
import com.example.placementtracker.entity.ApplicationStatus;
import com.example.placementtracker.entity.Job;
import com.example.placementtracker.repository.JobRepository;
import com.example.placementtracker.service.JobApplicationService;



@RestController
@RequestMapping("/api/admin/applications")
public class AdminApplicationController {

    private final JobApplicationService service;

    @Autowired
    public AdminApplicationController(JobApplicationService service) {
        this.service = service;
    }

    @GetMapping("/{jobId}")
    public Page<ApplicantResponseDto> getApplicants(
            @PathVariable Long jobId,
            @RequestParam int page,
            @RequestParam int size) {

        return service.getApplicants(jobId, PageRequest.of(page, size))
                .map(app -> new ApplicantResponseDto(
                        app.getId(),
                        app.getStudent().getFullName(),
                        app.getStudent().getBranch(),
                        app.getStatus().name()
                ));
    }

    @PutMapping("/{applicationId}/status/{status}")
    public void updateStatus(
            @PathVariable Long applicationId,
            @PathVariable ApplicationStatus status) {

        service.updateStatus(applicationId, status);
    }
}
