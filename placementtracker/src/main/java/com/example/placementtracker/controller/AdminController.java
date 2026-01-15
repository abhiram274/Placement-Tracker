package com.example.placementtracker.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.placementtracker.dto.StudentResponseDto;
import com.example.placementtracker.service.StudentService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
        
@Autowired
private StudentService studentService;

@GetMapping("/students")
public List<StudentResponseDto> getAllStudents() {

    return studentService.getAllStudents()
            .stream()
            .map(s -> new StudentResponseDto(
                    s.getFullName(),
                    s.getBranch(),
                    s.getYear(),
                    s.getEligible()
            ))
            .toList();
}
}
