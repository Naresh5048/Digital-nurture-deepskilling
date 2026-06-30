package com.cognizant.employeemanagement.repository;

import com.cognizant.employeemanagement.entity.Employee;
import com.cognizant.employeemanagement.projection.EmployeeSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNameContaining(String keyword);

    @Query("SELECT e FROM Employee e WHERE e.department.name = :deptName")
    List<Employee> fetchEmployeesByDepartmentName(@Param("deptName") String deptName);

    List<Employee> fetchByEmailDomain(@Param("domain") String domain);

    // FIX: Add explicit JPQL binding mapping to resolve the missing property crash
    @Query("SELECT e.name as name, e.email as email, d.name as departmentName " +
            "FROM Employee e JOIN e.department d WHERE e.name LIKE concat('%', :keyword, '%')")
    Page<EmployeeSummary> findProjectedByKeyword(@Param("keyword") String keyword, Pageable pageable);

    @Query("SELECT e.name as name, e.email as email, d.name as departmentName " +
            "FROM Employee e JOIN e.department d WHERE e.name LIKE concat('%', :keyword, '%')")
    Page<EmployeeSummary> findSummaryByKeyword(@Param("keyword") String keyword, Pageable pageable);
}