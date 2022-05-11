package com.portal.courseregistration;

import java.util.ArrayList;

public class Student extends Person {

    /*
    Properties
     */

    private int studentId;
    private float gpa;
    private int totalCredits;
    private ArrayList<Course> coursesCompleted;

    /*
    Constructors
     */

    public Student() {
        this.studentId = generateId();
    }

    public Student(float gpa, int totalCredits, ArrayList<Course> coursesCompleted) {
        this.gpa = gpa;
        this.totalCredits = totalCredits;
        this.coursesCompleted = coursesCompleted;
    }

    /*
    Function purpose: student id numbers will be even, instructor id numbers will be odd
     */
    @Override
    public int generateId() {
        double id = (Math.random() * 1000000000); // converts double into size of int
        int studentId = (int) Math.round(id); // rounds remaining decimal places to make id a whole number

        if (studentId % 2 != 0) {
            studentId += 1;
        }
        return studentId;
    }

    /*
    Getters & Setters
     */

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public ArrayList<Course> getCoursesCompleted() {
        return coursesCompleted;
    }

    public void setCoursesCompleted(ArrayList<Course> coursesCompleted) {
        this.coursesCompleted = coursesCompleted;
    }
}
