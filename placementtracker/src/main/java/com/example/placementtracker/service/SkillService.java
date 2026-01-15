package com.example.placementtracker.service;

import com.example.placementtracker.entity.Skill;
import com.example.placementtracker.entity.Student;
import com.example.placementtracker.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill addSkill(Student student, Skill skill) {
        skill.setStudent(student);
        return skillRepository.save(skill);
    }

    public List<Skill> getSkills(Student student) {
        return skillRepository.findByStudent(student);
    }
}
