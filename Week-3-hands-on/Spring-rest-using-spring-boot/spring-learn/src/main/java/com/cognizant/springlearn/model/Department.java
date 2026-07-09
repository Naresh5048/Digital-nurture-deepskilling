package com.cognizant.springlearn.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Department {
    @NotNull(message = "Department id cannot be null")
    private Integer id;

    @NotBlank(message = "Department name cannot be blank")
    @Size(min = 1, max = 30, message = "Department name width must be between 1 and 30 characters")
    private String name;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}