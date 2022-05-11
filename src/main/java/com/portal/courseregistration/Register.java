package com.portal.courseregistration;

import java.util.ArrayList;
import java.util.Scanner;

public class Register {

    /*
    Properties
     */

    private static Scanner input = new Scanner(System.in);
    private String registrationDecision;

    /*
    Constructor
     */

    public Register() {
    }

    /*
    Function purpose: prompt user to proceed with registration or search again, direct them accordingly
     */
    public void registrationPrompt() {
        System.out.print("\nEnter course course code to register or type 's' to search again:\n>> ");
        registrationDecision = input.nextLine();

        // similar structure to Demo class since restarting search
        if (registrationDecision.equals("s")) {
            CourseFinder courseFinder = new CourseFinder();
            String searchInput = courseFinder.collectSearchInformation("Subject");
            courseFinder.startFormatting("src/main/resources/Courses.csv", searchInput, 0, "Subject");
            registrationPrompt(); // recursive call

        } else {
            verifyCourseCode(CourseFinder.getExportList(), registrationDecision);
        }
    }

    /*
    Function purpose: cross-check course code with refined results course to make sure there is a match
     */
    public boolean verifyCourseCode(ArrayList<String[]> courseSearchResults, String courseCode) {

        boolean courseCodeMatch = false;

        for (int i = 0; i < courseSearchResults.size(); i++) {
            if (courseCode.equals(courseSearchResults.get(i)[2])) { // 2 = com.registration.Course Code Column
                courseCodeMatch = true;
                break;
            }
        }
        return courseCodeMatch;
    }

    /*
    Function purpose: verify a course code match or prompt the user to re-enter the course code
     */
    public boolean registrationCheck() {
        Boolean match = false;
        while (!match)
            if (verifyCourseCode(CourseFinder.getExportList(), registrationDecision)) {
                System.out.println("...Registering...");
                match = true;
            } else {
                System.out.print("Incorrect course code. Please re-enter:\n>> ");
                registrationDecision = input.nextLine();
            }
        return match;
    }

    /*
    Function purpose: allow the user to register for more than one course
     */
    public void repeatCourseRegistrationProcess(String filePath, int categoryIndex, String category) {
        CourseFinder courseFinder = new CourseFinder();
        while (true) {
            System.out.print("Would you like to register for another class? Type 'y' or 'n': ");
            if (input.nextLine().equals("y")) {
                String newInput = courseFinder.collectSearchInformation(category);
                courseFinder.startFormatting(filePath, newInput, categoryIndex, category);
                registrationPrompt();
                registrationCheck();
            } else {
                System.out.println("\nThank you!");
                System.exit(0);
            }
        }
    }
}