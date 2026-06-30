package com.cognizant.employeemanagement;

import com.cognizant.employeemanagement.entity.Department;
import com.cognizant.employeemanagement.entity.Employee;
import com.cognizant.employeemanagement.projection.EmployeeSummary;
import com.cognizant.employeemanagement.repository.DepartmentRepository;
import com.cognizant.employeemanagement.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

// Crucial static imports for assertions
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class EmployeeSystemTestSuite {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void executeFullEmployeeManagementMatrix() {
        Department dept = new Department();
        dept.setName("Information Technology");
        Department savedDept = departmentRepository.save(dept);
        assertNotNull(savedDept.getId());
        assertNotNull(savedDept.getCreatedDate());

        Employee emp = new Employee();
        emp.setName("Naresh Challa");
        emp.setEmail("naresh@lbrce.com");
        emp.setDepartment(savedDept);
        Employee savedEmp = employeeRepository.save(emp);
        assertNotNull(savedEmp.getId());
        assertEquals("SYSTEM_ADMIN", savedEmp.getCreatedBy());

        List<Employee> containResults = employeeRepository.findByNameContaining("Naresh");
        assertFalse(containResults.isEmpty());

        List<Employee> deptResults = employeeRepository.fetchEmployeesByDepartmentName("Information Technology");
        assertFalse(deptResults.isEmpty());

        List<Employee> domainResults = employeeRepository.fetchByEmailDomain("lbrce.com");
        assertFalse(domainResults.isEmpty());

        Page<EmployeeSummary> pagedResult = employeeRepository.findSummaryByKeyword(
                "Naresh", PageRequest.of(0, 5, Sort.by("name").ascending())
        );
        assertNotNull(pagedResult);
        assertEquals(1, pagedResult.getTotalElements());
        assertEquals("Information Technology", pagedResult.getContent().get(0).getDepartmentName());
        List<Employee> bulkInsertList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Employee batchEmp = new Employee();
            batchEmp.setName("Batch Worker " + i);
            batchEmp.setEmail("batchworker" + i + "@cognizant.com");
            batchEmp.setDepartment(savedDept);
            bulkInsertList.add(batchEmp);
        }
        List<Employee> batchSaved = employeeRepository.saveAll(bulkInsertList);
        assertEquals(10, batchSaved.size());
    }
}