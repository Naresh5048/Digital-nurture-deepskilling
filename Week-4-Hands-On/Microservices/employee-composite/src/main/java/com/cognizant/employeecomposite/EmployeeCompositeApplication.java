package com.cognizant.employeecomposite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeCompositeApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeCompositeApplication.class, args);
    }
}