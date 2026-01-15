package com.example.placementtracker.repository;

import com.example.placementtracker.entity.Skill;
import com.example.placementtracker.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    List<Skill> findByStudent(Student student);
}
