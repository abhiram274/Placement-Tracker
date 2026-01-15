package com.example.placementtracker.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.placementtracker.dto.CompanyRequestDto;
import com.example.placementtracker.dto.CompanyResponseDto;
import com.example.placementtracker.entity.Company;
import com.example.placementtracker.service.CompanyService;


@RestController
@RequestMapping("/api/admin/companies")
public class AdminCompanyController {

    private final CompanyService companyService;

    public AdminCompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<CompanyResponseDto> getAllCompanies() {
        return companyService.getAllCompanies()
                .stream()
                .map(c -> new CompanyResponseDto(
                        c.getId(),
                        c.getName(),
                        c.getLocation()
                ))
                .toList();
    }

    @PostMapping
    public void createCompany(@RequestBody CompanyRequestDto dto) {

        Company company = new Company();
        company.setName(dto.getName());
        company.setLocation(dto.getLocation());

        companyService.createCompany(company);
    }
}