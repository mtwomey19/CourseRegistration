package com.portal.courseregistration;

import com.portal.util.CSVFunctions;

public class CourseBuilder {

    /*
    Function purpose: append a new course to a csv file containing course information
     */
    public static void newCourse(String fileName, String values) {
        CSVFunctions.writeCSVFile(fileName, values);
    }
}
