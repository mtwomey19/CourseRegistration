package com.portal.courseregistration;

public class Course {

    /*
    Properties
     */

    private String subject;
    private String courseName;
    private String courseCode;
    private byte credits;
    private Instructor instructor;

    /*
    Constructors
     */

    public Course() {}

    public Course(String subject, String courseName, String courseCode, byte credits, Instructor instructor) {
        this.subject = subject;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
        this.instructor = instructor;
    }

    /*
    Getters & Setters
     */

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public byte getCredits() {
        return credits;
    }

    public void setCredits(byte credits) {
        this.credits = credits;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
