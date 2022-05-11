package com.portal.courseregistration;

public class Person {

    /*
    Properties
     */

    private int id;
    private String role;
    private String fName;
    private String lName;
    private String email;
    private String password;

    /*
    Constructor
     */

    public Person() {
        this.id = generateId(); // id set at initialization of Person object
    }

    private int generateId() {
        double id = (Math.random() * 1000000000); // converts double into size of int
        return (int) Math.round(id); // rounds remaining decimal places to make id a whole number
    }

    /*
    Getters & Setters
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
