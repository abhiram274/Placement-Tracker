package com.example.placementtracker.controller;

import com.example.placementtracker.dto.SkillRequestDto;
import com.example.placementtracker.dto.SkillResponseDto;
import com.example.placementtracker.entity.Skill;
import com.example.placementtracker.entity.Student;
import com.example.placementtracker.entity.User;
import com.example.placementtracker.repository.UserRepository;
import com.example.placementtracker.service.SkillService;
import com.example.placementtracker.service.StudentService;

import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/student/skills")
public class SkillController {

    private final SkillService skillService;
    private final StudentService studentService;
    private final UserRepository userRepository;

    public SkillController(SkillService skillService,
                           StudentService studentService,
                           UserRepository userRepository) {
        this.skillService = skillService;
        this.studentService = studentService;
        this.userRepository = userRepository;
    }

    @PostMapping
    public SkillResponseDto addSkill(
            @Valid @RequestBody SkillRequestDto request) {

        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Student student = studentService.getStudentByUser(user)
                .orElseThrow(() -> new RuntimeException("Student profile not found"));

        Skill skill = new Skill();
        skill.setName(request.getName());
        skill.setLevel(request.getLevel());

        Skill saved = skillService.addSkill(student, skill);

        return new SkillResponseDto(saved.getName(), saved.getLevel());
    }

    @GetMapping
    public List<SkillResponseDto> getMySkills() {

        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Student student = studentService.getStudentByUser(user)
                .orElseThrow(() -> new RuntimeException("Student profile not found"));

        return skillService.getSkills(student)
                .stream()
                .map(skill -> new SkillResponseDto(
                        skill.getName(),
                        skill.getLevel()))
                .collect(Collectors.toList());
    }
}
