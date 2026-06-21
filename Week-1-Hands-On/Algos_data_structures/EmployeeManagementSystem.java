package com.cts.structures.exercise04;

class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;
    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Employee [ID=" + employeeId + ", Name=" + name + ", Role=" + position + ", Pay=₹" + salary + "]";
    }
}

class EmployeeRegistry {
    private Employee[] registryArray;
    private int elementCount;

    public EmployeeRegistry(int fixedCapacity) {
        this.registryArray = new Employee[fixedCapacity];
        this.elementCount = 0;
    }

    public void addEmployee(Employee emp) {
        if (elementCount < registryArray.length) {
            registryArray[elementCount++] = emp;
            System.out.println("Enrolled Employee: " + emp.getName());
        } else {
            System.out.println("Registry is full. Cannot add employee.");
        }
    }
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < elementCount; i++) {
            if (registryArray[i].getEmployeeId().equalsIgnoreCase(employeeId)) {
                return registryArray[i];
            }
        }
        return null;
    }
    public void traverseRecords() {
        System.out.println("\nListing All Employee Records:");
        for (int i = 0; i < elementCount; i++) {
            System.out.println(registryArray[i]);
        }
    }
    public void deleteEmployee(String employeeId) {
        int foundIndex = -1;
        for (int i = 0; i < elementCount; i++) {
            if (registryArray[i].getEmployeeId().equalsIgnoreCase(employeeId)) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex != -1) {
            // Shift elements to fill the gap left by the deleted record [cite: 59]
            for (int i = foundIndex; i < elementCount - 1; i++) {
                registryArray[i] = registryArray[i + 1];
            }
            registryArray[elementCount - 1] = null;
            elementCount--;
            System.out.println("Successfully removed employee with ID: " + employeeId);
        } else {
            System.out.println("Employee ID matching query target not found.");
        }
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== Employee Registry Run Unit ===\n");
        EmployeeRegistry officeHr = new EmployeeRegistry(5);
        officeHr.addEmployee(new Employee("E001", "Challa Naresh", "DevOps Engineer", 85000.00));
        officeHr.addEmployee(new Employee("E002", "Anjali Sharma", "QA Engineer", 62000.00));
        officeHr.traverseRecords();
        System.out.println("\n Performing Search Action");
        Employee query = officeHr.searchEmployee("E001");
        System.out.println("Search Result: " + (query != null ? query : "Not Found"));

        System.out.println("\n Performing Deletion Action ");
        officeHr.deleteEmployee("E002");
        officeHr.traverseRecords();
    }
}