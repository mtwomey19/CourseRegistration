package com.portal.util;

import java.io.*;

public class CSVFunctions {

    /*
    Function purpose: save data to CSV files
    Note: values must be entered in String format ("a" + "," + "b" + "," + "c")
     */
    public static void writeCSVFile(String filePath, String values) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.println(values); // input written to CSV file
            printWriter.flush();
            printWriter.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Function purpose: save CSV data into a 2-D String Array
     */
    public static String[][] parseCSV(String filePath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            String[][] csvData = new String[100][10]; // values can be adjusted based on size of dataset

            // defining variables prior to while loop
            String[] row;
            String line = "";
            int count = 0;

            // Purpose: convert CSV data into a 2-D String Array
            // "while file has another line, continue reading data"
            while ((line = bufferedReader.readLine()) != null) {
                row = line.split(",");
                csvData[count] = row;
                count++;
            }
            bufferedReader.close();
            return csvData;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
