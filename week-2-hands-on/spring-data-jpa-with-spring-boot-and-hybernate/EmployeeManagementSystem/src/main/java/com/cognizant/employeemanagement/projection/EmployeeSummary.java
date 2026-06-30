package com.cognizant.employeemanagement.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeSummary {
    String getName();
    String getEmail();
    @Value("#{target.department.name}")
    public String getDepartmentName();
}