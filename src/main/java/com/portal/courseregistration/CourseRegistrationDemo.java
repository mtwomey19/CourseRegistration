// Program: Course Registration
// Written by: Michael Twomey
// Description:
//     	Sign in to the registration portal and search for courses
//     	based on subject area. Enter the course code to complete the
//		registration. You may choose to register for more than one class
//		or exit at your own discretion.
// Challenges:
//      One of the biggest challenges early on was connecting classes while preserving data.
//      Often I would use composition, however, creating a new instantiating a new object
//		made many of the values I was hoping to access null. I found ways around this challenge
//		by storing some of the data I needed in static ArrayLists which preserved the data upon
//		when accessing data in different classes.
//		Second, I wanted to save data even when the program ended to give the program a similar
//		feel to the course registration system we use at the college. I quickly realized I needed
//		to store the data in an external source and with minimal database experience I tried working
//		with CSV files. I found reading and writing to/from CSV files tricky. I tried different
//		libraries and ultimately settled on using a combination of FileReader/Writer,
//		BufferedReader/Writer, and PrintReader/Writer. I started finding success with the CSV files
// 		once I was able to translate them into arrays.
//		Lastly, my stretch goal was to send a confirmation email when the user registered
//		for the course. I came close using the Spring Framework, however, I do not have a strong
//		understanding of what is happening under the hood yet, so I'm struggling to adjust when the
//		email is sent. Right now it is sending at the start of the program. After the final exam,
//		I look forward to learning how to adjust the timing of the email delivery.
// Note:
//		This program focuses predominantly on the student side of course registration.
//		I discovered during this project that there are an infinite number of ways to enhance
//		a course registration system. In the future, I would like to continue building out the
//		program, so it can stand alongside a commercial course registration system!
//
//
// Time Spent: 24:30:00
//
//                       Revision History
// Date:                        By:                         Action:
// ---------------------------------------------------------------
// 05/02/2022                   MT                          Created
// 05/04/2022                   MT                          Outlined Classes
// 05/07/2022					MT							Built Login Functionality
// 05/08/2022					MT							Built Search Functionality
// 05/09/2022					MT							Made Course Registration Continuous
// 05/10/2022					MT							Attempted Email Feature
// 05/11/2022					MT							Revised


package com.portal.courseregistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;


@SpringBootApplication
public class CourseRegistrationDemo {

	@Autowired
	private EmailSender emailSender;

	public static void main(String[] args) {
		// Java Mail Sender (part of the Spring Framework) used to send confirmation email
		SpringApplication.run(CourseRegistrationDemo.class, args);

		// Comment out new courses after initial build to prevent repeats
//		CourseBuilder.newCourse("src/main/resources/Courses.csv",
//				"Math" + "," + "Calculus I" + "," + "MA-100" + "," + "4" + "," + "Satvat"
//				);

		// Begin Student Login
		System.out.println("\n\nCOURSE REGISTRATION\n\n");

		Login login = new Login();
		login.signIn(login.determineUserType());

		// Begin registration
		CourseFinder courseFinder = new CourseFinder();
		courseFinder.startRegistration();
		String searchInput = courseFinder.collectSearchInformation("Subject");
		courseFinder.startFormatting("src/main/resources/Courses.csv", searchInput, 0, "Subject");

		// Confirm registration
		Register register = new Register();
		register.registrationPrompt();
		register.registrationCheck();

		// Repeat
		register.repeatCourseRegistrationProcess("src/main/resources/Courses.csv", 0, "Subject");
	}

	/*
	Function purpose:
		- call sendEmail method from EmailSender class
		- input message contents
		- @EventListener needed because of static context of main method
	 */
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
		emailSender.sendEmail("mtwomey19@gmail.com",
				"Course Registration Confirmation",
				"Thank you for registering. Have a great day.");
	}
}