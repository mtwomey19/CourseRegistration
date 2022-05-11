package com.portal.courseregistration;

import java.util.ArrayList;

public class Student extends Person {

    /*
    Properties
     */

    private float gpa;
    private int totalCredits;
    private ArrayList<Course> coursesCompleted;

    /*
    Constructors
     */

    public Student() {}

    public Student(float gpa, int totalCredits, ArrayList<Course> coursesCompleted) {
        this.gpa = gpa;
        this.totalCredits = totalCredits;
        this.coursesCompleted = coursesCompleted;
    }

    /*
    Getters & Setters
     */

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
