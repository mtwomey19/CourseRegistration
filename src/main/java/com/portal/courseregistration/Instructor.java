package com.portal.courseregistration;

public class Instructor extends Person {

    /*
    Properties
     */

    private int instructorId;
    private int numYearsProfessor;
    private double salary;
    private String subjectArea;

    /*
    Constructors
     */

    public Instructor() {
        this.instructorId = generateId();
    }

    public Instructor(int numYearsProfessor, double salary, String subjectArea) {
        this.numYearsProfessor = numYearsProfessor;
        this.salary = salary;
        this.subjectArea = subjectArea;
    }

    /*
Function purpose: student id numbers will be even, instructor id numbers will be odd
 */
    @Override
    public int generateId() {
        double id = (Math.random() * 1000000000); // converts double into size of int
        int instructorId = (int) Math.round(id); // rounds remaining decimal places to make id a whole number

        if (instructorId % 2 == 0) {
            instructorId += 1;
        }
        return instructorId;
    }

    /*
    Getters & Setters
     */

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

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