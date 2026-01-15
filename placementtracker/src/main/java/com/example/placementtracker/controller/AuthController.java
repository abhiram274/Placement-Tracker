package com.example.placementtracker.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.placementtracker.dto.LoginRequestDto;
import com.example.placementtracker.dto.LoginResponseDto;
import com.example.placementtracker.dto.SignupRequestDto;
import com.example.placementtracker.entity.Student;
import com.example.placementtracker.entity.User;
import com.example.placementtracker.security.JwtUtil;
import com.example.placementtracker.service.StudentService;
import com.example.placementtracker.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final StudentService studentService;

    public AuthController(UserService userService,
                          StudentService studentService) {
        this.userService = userService;
        this.studentService = studentService;
    }

    // LOGIN (unchanged)
    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto request) {

        User user = userService.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        boolean authenticated = userService.authenticate(
                request.getUsername(),
                request.getPassword()
        );

        if (!authenticated) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = JwtUtil.generateToken(
                user.getUsername(),
                user.getRole()
        );

        return new LoginResponseDto(token);
    }

    // ✅ SIGNUP (NEW, IMPORTANT)
    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequestDto request) {

        // 1. Create User
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole("STUDENT");

        User savedUser = userService.createUser(user);

        // 2. Create Student Profile
        Student student = new Student();
        student.setUser(savedUser);
        student.setFullName(request.getFullName());
        student.setBranch(request.getBranch());
        student.setYear(request.getYear());

        studentService.createOrUpdateProfile(savedUser, student);
    }
}
