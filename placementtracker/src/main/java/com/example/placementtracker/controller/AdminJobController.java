package com.example.placementtracker.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.placementtracker.dto.JobRequestDto;
import com.example.placementtracker.entity.Job;
import com.example.placementtracker.service.JobService;
// import com.example.placementtracker.repository.CompanyRepository;
// import com.example.placementtracker.entity.Company;

@RestController
@RequestMapping("/api/admin/jobs")
public class AdminJobController {

    private final JobService jobService;
    // private final CompanyRepository companyRepository;

    public AdminJobController(JobService jobService) {//CompanyRepository companyRepository
        this.jobService = jobService;
        // this.companyRepository = companyRepository;
    }

    @PostMapping
    public void createJob(@RequestBody JobRequestDto dto) {
        Job job = new Job();
        
        // Find company by name
        // Company company = companyRepository.findByName(dto.getCompanyName())
        //     .orElseThrow(() -> new RuntimeException("Company not found: " + dto.getCompanyName()));
        
        job.setCompanyName(dto.getCompanyName());
        job.setRoleName(dto.getRoleName());
        job.setMinYear(dto.getMinYear());
        job.setDescription(dto.getDescription());

        jobService.createJob(job);
    }
}