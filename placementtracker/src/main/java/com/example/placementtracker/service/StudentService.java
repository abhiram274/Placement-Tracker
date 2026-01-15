package com.example.placementtracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.placementtracker.entity.Student;
import com.example.placementtracker.entity.User;
import com.example.placementtracker.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createOrUpdateProfile(User user, Student student) {
        student.setUser(user);
        return studentRepository.save(student);
    }

    public Optional<Student> getStudentByUser(User user) {
        return studentRepository.findByUser(user);
    }

    public List<Student> getAllStudents() {
    return studentRepository.findAll();
    }
}
