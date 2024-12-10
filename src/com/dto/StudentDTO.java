package com.dto;

public class StudentDTO {
    private String student_No;
    private String department_No;
    private String student_Name;
    private String student_SSN;
    private String student_Address;
    private String entrance_Date;
    private char absence_YN;
    private String coach_Professor_No;


    public StudentDTO() {
    }

    public StudentDTO(String student_No, String department_No, String student_Name, String student_SSN, String student_Address, String entrance_Date, char absence_YN, String coach_Professor_No) {
        this.student_No = student_No;
        this.department_No = department_No;
        this.student_Name = student_Name;
        this.student_SSN = student_SSN;
        this.student_Address = student_Address;
        this.entrance_Date = entrance_Date;
        this.absence_YN = absence_YN;
        this.coach_Professor_No = coach_Professor_No;
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

    public String getStudent_SSN() {
        return student_SSN;
    }

    public void setStudent_SSN(String student_SSN) {
        this.student_SSN = student_SSN;
    }

    public String getStudent_Address() {
        return student_Address;
    }

    public void setStudent_Address(String student_Address) {
        this.student_Address = student_Address;
    }

    public String getEntrance_Date() {
        return entrance_Date;
    }

    public void setEntrance_Date(String entrance_Date) {
        this.entrance_Date = entrance_Date;
    }

    public char getAbsence_YN() {
        return absence_YN;
    }

    public void setAbsence_YN(char absence_YN) {
        this.absence_YN = absence_YN;
    }

    public String getCoach_Professor_No() {
        return coach_Professor_No;
    }

    public void setCoach_Professor_No(String coach_Professor_No) {
        this.coach_Professor_No = coach_Professor_No;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "student_No='" + student_No + '\'' +
                ", department_No='" + department_No + '\'' +
                ", student_Name='" + student_Name + '\'' +
                ", student_SSN='" + student_SSN + '\'' +
                ", student_Address='" + student_Address + '\'' +
                ", entrance_Date='" + entrance_Date + '\'' +
                ", absence_YN=" + absence_YN +
                ", coach_Professor_No='" + coach_Professor_No + '\'' +
                '}';
    }
}