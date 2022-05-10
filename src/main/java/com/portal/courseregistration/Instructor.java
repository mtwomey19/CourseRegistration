package com.portal.courseregistration;

public class Instructor extends Person {

    private int numYearsProfessor;
    private double salary;
    private String subjectArea;

    public Instructor() {}

    public Instructor(int numYearsProfessor, double salary, String subjectArea) {
        this.numYearsProfessor = numYearsProfessor;
        this.salary = salary;
        this.subjectArea = subjectArea;
    }

    /*
    Getters & Setters
     */

    public int getNumYearsProfessor() {
        return numYearsProfessor;
    }

    public void setNumYearsProfessor(int numYearsProfessor) {
        this.numYearsProfessor = numYearsProfessor;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSubjectArea() {
        return subjectArea;
    }

    public void setSubjectArea(String subjectArea) {
        this.subjectArea = subjectArea;
    }
}
