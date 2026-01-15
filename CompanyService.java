package com.example.placementtracker.service;
import com.example.placementtracker.entity.Company;
import com.example.placementtracker.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
