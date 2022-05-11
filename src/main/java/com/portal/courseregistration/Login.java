package com.portal.courseregistration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Login {

    /*
    Properties
     */

    private static Scanner input = new Scanner(System.in); // better suited as class lvl var as opposed to object lvl var
    private Person person = new Person();
    private String email;
    private String password;
    private static ArrayList<Person> savedPerson = new ArrayList<>();

    /*
    Constructor
     */

    public Login() {}

    /*
    Procedures
     */

    /*
    Function purpose: first step in flow chart: determine if user is a new or returning user
     */
    public String determineUserType() {
        System.out.print("Type 'n' for new user, type 'r' for returning user: ");
        return input.nextLine();
    }

    /*
    Function purpose: route program to correct login screen based on new or returning user
     */
    public void signIn(String userType) {
        if (userType.equals("n"))
            collectNewUserInfo();
        else {
            returningUser();
            verifyUserCredentials();
        }
    }

    /*
    Function purpose: sign in returning user
     */
    private void returningUser() {
        System.out.print("Email: ");
        email = input.nextLine();
        System.out.print("Password: ");
        password = input.nextLine();
    }

    /*
    Function purpose:
        - cross-check with user entered email and password with data from CSV file
        - user has 10 attempts before account locks
     */
    private void verifyUserCredentials() {
        // email and password from CSV file
        HashMap<String, String> loginCredentials = PersonSaver.parseLoginCredentials();

        int attempts = 0;

        while (attempts < 10) {
            if (loginCredentials.get(email) != null && loginCredentials.get(email).equals(password)) {
                System.out.println("Welcome back!");
                break;
            } else {
                System.out.println("Incorrect email or password. Please try again.");
                attempts += 1;
                returningUser();
            }
        }
        if (attempts > 9) {
            System.out.println("Account temporarily locked. Please contact IT.");
            System.exit(0);
        }
    }

    /*
    Function purpose: Collect information from new user and save it to CSV file
     */
    private void collectNewUserInfo() {
        System.out.println("Welcome! Please enter the following information.");
        System.out.print("Type 'i' for instructor, type 's' for student: ");
        person.setRole(input.nextLine());
        System.out.print("First Name: ");
        person.setFName(input.nextLine());
        System.out.print("Last Name: ");
        person.setLName(input.nextLine());
        System.out.print("Email: ");
        person.setEmail(input.nextLine());
        System.out.print("Password: ");
        person.setPassword(input.nextLine());
        savedPerson.add(person);

        PersonSaver.savePersonToFile(); // save info to CSV file
    }

    /*
    Setters & Getters
     */

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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

    /*
    Function purpose:
        - modified get method to extract data from new user login
        - otherwise data will be lost from new user when a Person object is created in the Person Saver Class
     */
    public static Person getSavedPerson() {
        return savedPerson.get(0);
    }

    public static void setSavedPerson(ArrayList<Person> savedPerson) {
        Login.savedPerson = savedPerson;
    }
}
