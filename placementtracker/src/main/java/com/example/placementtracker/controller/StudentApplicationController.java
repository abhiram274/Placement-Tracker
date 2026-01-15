package com.example.placementtracker.controller;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.placementtracker.entity.Job;
import com.example.placementtracker.entity.Student;
import com.example.placementtracker.entity.User;
import com.example.placementtracker.repository.JobRepository;
import com.example.placementtracker.repository.UserRepository;
import com.example.placementtracker.service.JobApplicationService;
import com.example.placementtracker.service.StudentService;


@RestController
@RequestMapping("/api/student/applications")
public class StudentApplicationController {

    private final JobRepository jobRepository;
    private final JobApplicationService service;
    private final StudentService studentService;
    private final UserRepository userRepository;

    public StudentApplicationController(JobRepository jobRepository, JobApplicationService service, StudentService studentService, UserRepository userRepository) {
        this.jobRepository = jobRepository;
        this.service = service;
        this.studentService = studentService;
        this.userRepository = userRepository;
    }

    @PostMapping("/apply/{jobId}")
    public void apply(@PathVariable Long jobId) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username).orElseThrow();
        Student student = studentService.getStudentByUser(user).orElseThrow();

        Job job = jobRepository.findById(jobId).orElseThrow();

        service.apply(job, student);
    }
}