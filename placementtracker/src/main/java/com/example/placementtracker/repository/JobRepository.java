package com.example.placementtracker.repository;
// import com.example.placementtracker.entity.Company;
import com.example.placementtracker.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByCompanyName(String companyName);
}
