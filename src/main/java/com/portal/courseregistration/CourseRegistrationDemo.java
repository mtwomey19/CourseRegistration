package com.portal.courseregistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;

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

		CourseFinder courseFinder = new CourseFinder();
		courseFinder.startRegistration();
		String searchInput = courseFinder.collectSearchInformation("Subject");
		courseFinder.startFormatting("src/main/resources/Courses.csv", searchInput, 0);




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
