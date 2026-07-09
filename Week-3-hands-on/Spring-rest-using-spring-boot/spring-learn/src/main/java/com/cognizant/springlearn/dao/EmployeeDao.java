package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {
    private static List<Employee> EMPLOYEE_LIST = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public EmployeeDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = context.getBean("employeeList", ArrayList.class);
    }

    public List<Employee> getAllEmployees() { return EMPLOYEE_LIST; }

    public void updateEmployee(Employee updatedEmployee) throws EmployeeNotFoundException {
        Employee target = EMPLOYEE_LIST.stream()
                .filter(e -> e.getId().equals(updatedEmployee.getId()))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee target missing from domain maps"));

        target.setName(updatedEmployee.getName());
        target.setSalary(updatedEmployee.getSalary());
        target.setPermanent(updatedEmployee.getPermanent());
        target.setDateOfBirth(updatedEmployee.getDateOfBirth());
        target.setDepartment(updatedEmployee.getDepartment());
        target.setSkills(updatedEmployee.getSkills());
    }

    public void deleteEmployee(Integer id) throws EmployeeNotFoundException {
        Employee target = EMPLOYEE_LIST.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Target Employee Id does not exist"));
        EMPLOYEE_LIST.remove(target);
    }
}