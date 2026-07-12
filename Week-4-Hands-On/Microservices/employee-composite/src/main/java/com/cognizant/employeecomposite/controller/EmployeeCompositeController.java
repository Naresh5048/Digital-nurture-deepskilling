package com.cognizant.employeecomposite.controller;

import com.cognizant.employeecomposite.model.CompositeProfile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeCompositeController {

    @GetMapping("/employee-composite-summary")
    public CompositeProfile getAggregatedProfileData() {
        return new CompositeProfile(
                "Naresh Challa",
                "USD",
                "United States",
                8000
        );
    }
}