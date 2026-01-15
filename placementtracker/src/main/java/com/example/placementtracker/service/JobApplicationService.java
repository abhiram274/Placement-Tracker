package com.example.placementtracker.service;
import com.example.placementtracker.entity.Job;
import com.example.placementtracker.entity.JobApplication;
import com.example.placementtracker.entity.Student;
import com.example.placementtracker.entity.ApplicationStatus;
import com.example.placementtracker.repository.JobApplicationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class JobApplicationService {

    private final JobApplicationRepository repository;

    public JobApplicationService(JobApplicationRepository repository) {
        this.repository = repository;
    }

    public void apply(Job job, Student student) {

        if (repository.existsByJobIdAndStudentId(job.getId(), student.getId())) {
            throw new RuntimeException("Already applied");
        }

        JobApplication app = new JobApplication();
        app.setJob(job);
        app.setStudent(student);
        app.setStatus(ApplicationStatus.APPLIED);

        repository.save(app);
    }

    public Page<JobApplication> getApplicants(Long jobId, Pageable pageable) {
        return repository.findByJobId(jobId, pageable);
    }

    public void updateStatus(Long appId, ApplicationStatus status) {
        JobApplication app = repository.findById(appId).orElseThrow();
        app.setStatus(status);
        repository.save(app);
    }
}