package com.example.placementtracker.repository;

import com.example.placementtracker.entity.Job;
import com.example.placementtracker.entity.JobApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

    Page<JobApplication> findByJobId(Long jobId, Pageable pageable);

    boolean existsByJobIdAndStudentId(Long jobId, Long studentId);
}
