package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.dao.DepartmentDao;
import com.cognizant.springlearn.model.Department;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentDao departmentDao;

    public DepartmentController(DepartmentDao departmentDao) { this.departmentDao = departmentDao; }

    @GetMapping
    public List<Department> getAllDepartments() { return departmentDao.getAllDepartments(); }
}