package com.cts.exercise10_mvc;

class Student {
    private String name;
    private String id;
    private String grade;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}

class StudentView {
    public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
        System.out.println("ACADEMIC REGULATION DATA SHEET");
        System.out.println("Identification Registry Tag: " + studentId);
        System.out.println("Subject Profile Identity: " + studentName);
        System.out.println("Performance Metrics Grade: " + studentGrade);
    }
}

class StudentController {
    private Student dataModel;
    private StudentView interfaceView;

    public StudentController(Student model, Student view) {
        this.dataModel = model;
        this.interfaceView = view;
    }

    public void setStudentName(String name) { dataModel.setName(name); }
    public String getStudentName() { return dataModel.getName(); }

    public void setStudentId(String id) { dataModel.setId(id); }
    public String getStudentId() { return dataModel.getId(); }

    public void setStudentGrade(String grade) { dataModel.setGrade(grade); }
    public String getStudentGrade() { return dataModel.getGrade(); }

    public void refreshView() {
        interfaceView.displayStudentDetails(dataModel.getName(), dataModel.getId(), dataModel.getGrade());
    }
}

public class MVCPatternExample {
    public static void main(String[] args) {
        System.out.println("MVC Architecture Component Validation\n");

        Student structuralRecord = new Student();
        structuralRecord.setName("Challa Naresh");
        structuralRecord.setId("LBRCE-IT-301");
        structuralRecord.setGrade("A+");

        StudentView outputTerminalView = new StudentView();

        StudentController centralSessionController = new StudentController(structuralRecord, outputTerminalView);

        centralSessionController.refreshView();

        System.out.println(" Upstream event modifying local properties via engine pipeline Controller");
        centralSessionController.setStudentGrade("O [Outstanding]");
        
        centralSessionController.refreshView();
    }
}