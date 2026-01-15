package com.example.placementtracker.controller;
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.placementtracker.dto.JobResponseDto;
import com.example.placementtracker.service.JobService;
import java.util.List;

@RestController
@RequestMapping("/api/student/jobs")
public class StudentJobController {

    private final JobService jobService;

    public StudentJobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<JobResponseDto> viewJobs() {

        return jobService.getAllJobs()
                .stream()
                .map(job -> new JobResponseDto(
                        job.getId(),
                        job.getRoleName(),
                        job.getMinYear(),
                        job.getCompanyName()
                ))
                .toList();
    }
}