package com.dto;

public class StudentDetailsDTO {
    private String student_No;
    private String department_No;
    private String student_Name;
    private String student_Grade;
    private String term_no;
    private double point;
    private String department_Name;

    public StudentDetailsDTO() {
    }

    public StudentDetailsDTO(String student_No, String department_No, String student_Name, String student_Grade, String term_no, double point, String department_Name) {
        this.student_No = student_No;
        this.department_No = department_No;
        this.student_Name = student_Name;
        this.student_Grade = student_Grade;
        this.term_no = term_no;
        this.point = point;
        this.department_Name = department_Name;
    }

    public String getStudent_No() {
        return student_No;
    }

    public void setStudent_No(String student_No) {
        this.student_No = student_No;
    }

    public String getDepartment_No() {
        return department_No;
    }

    public void setDepartment_No(String department_No) {
        this.department_No = department_No;
    }

    public String getStudent_Name() {
        return student_Name;
    }

    public void setStudent_Name(String student_Name) {
        this.student_Name = student_Name;
    }

    public String getStudent_Grade() {
        return student_Grade;
    }

    public void setStudent_Grade(String student_Grade) {
        this.student_Grade = student_Grade;
    }

    public String getTerm_no() {
        return term_no;
    }

    public void setTerm_no(String term_no) {
        this.term_no = term_no;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getDepartment_Name() {
        return department_Name;
    }

    public void setDepartment_Name(String department_Name) {
        this.department_Name = department_Name;
    }

    @Override
    public String toString() {
        return "StudentDetailsDTO{" +
                "student_No='" + student_No + '\'' +
                ", department_No='" + department_No + '\'' +
                ", student_Name='" + student_Name + '\'' +
                ", student_Grade='" + student_Grade + '\'' +
                ", term_no='" + term_no + '\'' +
                ", point=" + point +
                ", department_Name='" + department_Name + '\'' +
                '}';
    }
}