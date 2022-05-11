package com.portal.courseregistration;

import com.portal.util.CSVFunctions;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CourseFinder {

    /*
    Properties
     */

    private String subject;
    private String courseName;
    private String courseCode;
    private String credits;
    private String instructorLastName;

    private ArrayList<String> searchedValues = new ArrayList<>();
    private ArrayList<String[]> courseList;
    private static ArrayList<String[]> exportList;

    private static Scanner input = new Scanner(System.in);

    /*
    Procedure
     */

    /*
    Function purpose: route user to search for courses or exit portal
     */
    public void startRegistration() {
        System.out.print("Type 's' to search for courses, type 'e' to exit: ");
        String proceedToRegistration = input.nextLine();

        if (!proceedToRegistration.equals("s")) {
            System.out.println("...Exiting Course Registration Portal...");
            System.exit(0);
        }
    }

    /*
    Function purpose: collect user search information based on course categories
     */
    public String collectSearchInformation(String category) {
        System.out.print("Search by " + category + "\n>> ");
        return input.nextLine();
    }

    /*
    Function purpose: Narrow down course offerings based on user search input
     */
    public ArrayList<String[]> returnSearchResults(String filePath, String searchInput, int categoryIndex) {

        ArrayList<String[]> courseList = removeNullValues(filePath);
        String[] individualCourseData;

        // start refining results by category
        for (int i = 0; i < courseList.size(); i++) {
            individualCourseData = courseList.get(i);
            if (!searchInput.equals(individualCourseData[categoryIndex])) {
                courseList.remove(courseList.get(i));
                i--; // compensate for remove method shifting index
            }
        }
        exportList = courseList; // set static exportList to preserve refined list
        return courseList;
    }

    /*
    Function purpose: updates the course list used for formatting by calling return search results
     */
    public ArrayList<String[]> updateCourseList(String filePath, String searchInput, int categoryIndex) {
        return returnSearchResults(filePath, searchInput, categoryIndex);
    }

    /*
    Function purpose: remove null values from 2-D array sourced from CSV file to improve the aesthetics of the output
     */
    private ArrayList<String[]> removeNullValues(String filePath) {

        String[][] courseData = CSVFunctions.parseCSV(filePath);
        ArrayList<String[]> courseList = new ArrayList<>(Arrays.asList(courseData)); // convert 2-D array to list for more functionality

        ArrayList<String[]> refinedCourseList = new ArrayList<>();

        // remove null values
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i)[0] != null)
                refinedCourseList.add(courseList.get(i));
        }
        return refinedCourseList;
    }

    /*
    Function purpose: trigger formatting procedure by making for easy call in demo class
     */
    public void startFormatting(String filePath, String searchInput, int categoryIndex) {
        formatResults(updateCourseList(filePath, searchInput, categoryIndex));
    }

    /*
    Function purpose: extract search result data to be displayed and pass it through the format method
     */
    public void formatResults(ArrayList<String[]> refinedCourseList) {
        for (int i = 0; i < refinedCourseList.size(); i++) {
            format(refinedCourseList.get(i));
        }
    }

    /*
    Function purpose: center data in column and rows
     */
    public void format(String[] columnData) {
        String header = "\n";

        for (int i = 0; i < columnData.length; i++) {
            header += StringUtils.center(columnData[i], 20);
        }
        System.out.println(header);
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

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getInstructorLastName() {
        return instructorLastName;
    }

    public void setInstructorLastName(String instructorLastName) {
        this.instructorLastName = instructorLastName;
    }

    public ArrayList<String> getSearchedValues() {
        return searchedValues;
    }

    public void setSearchedValues(ArrayList<String> searchedValues) {
        this.searchedValues = searchedValues;
    }

    public ArrayList<String[]> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<String[]> courseList) {
        this.courseList = courseList;
    }

    public static ArrayList<String[]> getExportList() {
        return exportList;
    }

    public static void setExportList(ArrayList<String[]> exportList) {
        CourseFinder.exportList = exportList;
    }
}
