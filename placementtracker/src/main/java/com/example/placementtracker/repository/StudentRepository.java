package com.example.placementtracker.repository;

import com.example.placementtracker.entity.Student;
import com.example.placementtracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByUser(User user);
}
