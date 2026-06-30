package com.cognizant.employeemanagement.controller;

import com.cognizant.employeemanagement.entity.Employee;
import com.cognizant.employeemanagement.projection.EmployeeSummary;
import com.cognizant.employeemanagement.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Employee create(@RequestBody Employee emp) {
        return repository.save(emp);
    }

    @GetMapping("/search/dept")
    public List<Employee> getByDept(@RequestParam String name) {
        return repository.fetchEmployeesByDepartmentName(name);
    }

    @GetMapping("/search/domain")
    public List<Employee> getByDomain(@RequestParam String domain) {
        return repository.fetchByEmailDomain(domain);
    }

    @GetMapping("/search/paged")
    public Page<EmployeeSummary> getPagedSummaries(
            @RequestParam String keyword,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        // Pass both parameters into your updated repository method layout
        return repository.findProjectedByKeyword(keyword, pageable);
    }
}