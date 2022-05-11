package com.portal.courseregistration;

import com.portal.util.CSVFunctions;

import java.util.HashMap;

public class PersonSaver {

    /*
    Function purpose: Extract data from new user (collected in Login class) and write data to CSV file
     */
    public static void savePersonToFile() {

        Person person = Login.getSavedPerson(); // preserves Person data from Login class

        CSVFunctions.writeCSVFile("src/main/resources/Persons.csv",
                person.getId() + "," +
                        person.getRole() + "," +
                        person.getFName() + "," +
                        person.getLName() + "," +
                        person.getEmail() + "," +
                        person.getPassword()
        );
    }

    /*
    Function purpose: return a map containing email and password for each Person
     */
    public static HashMap<String, String> parseLoginCredentials() {

        HashMap<String, String> loginCredentials = new HashMap<>();

        String[][] personsData = CSVFunctions.parseCSV("src/main/resources/Persons.csv");

        for (int i = 0; i < personsData.length; i++)
            loginCredentials.put(personsData[i][4], personsData[i][5]); // 4 = email column, 5 = password column

        return loginCredentials;
    }
}
