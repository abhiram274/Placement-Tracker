package com.example.placementtracker.controller;

import com.example.placementtracker.dto.StudentRequestDto;
import com.example.placementtracker.dto.StudentResponseDto;
import com.example.placementtracker.entity.Student;
import com.example.placementtracker.entity.User;
import com.example.placementtracker.repository.UserRepository;
import com.example.placementtracker.service.StudentService;

import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;
    private final UserRepository userRepository;

    public StudentController(StudentService studentService,
                             UserRepository userRepository) {
        this.studentService = studentService;
        this.userRepository = userRepository;
    }

    @PostMapping("/profile")
    public StudentResponseDto createProfile(
            @Valid @RequestBody StudentRequestDto request) {

        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Student student = new Student();
        student.setFullName(request.getFullName());
        student.setBranch(request.getBranch());
        student.setYear(request.getYear());

        Student saved = studentService.createOrUpdateProfile(user, student);

        return new StudentResponseDto(
                saved.getFullName(),
                saved.getBranch(),
                saved.getYear(),
                saved.getEligible()
        );
    }

    @GetMapping("/profile")
    public StudentResponseDto getMyProfile() {

        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Student student = studentService.getStudentByUser(user)
                .orElseThrow(() -> new RuntimeException("Profile not created"));

        return new StudentResponseDto(
                student.getFullName(),
                student.getBranch(),
                student.getYear(),
                student.getEligible()
        );
    }
}
