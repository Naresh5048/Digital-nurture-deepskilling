package com.cognizant.springlearn.service;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) { this.employeeDao = employeeDao; }

    public List<Employee> getAllEmployees() { return employeeDao.getAllEmployees(); }
    public void updateEmployee(Employee employee) throws EmployeeNotFoundException { employeeDao.updateEmployee(employee); }
    public void deleteEmployee(Integer id) throws EmployeeNotFoundException { employeeDao.deleteEmployee(id); }
}