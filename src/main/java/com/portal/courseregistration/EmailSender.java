package com.portal.courseregistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

    @Autowired
    private JavaMailSender mailSender;

    /*
    Function purpose: prepare and send email when called
     */
    public void sendEmail(String recipient, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();

        // fill out message
        message.setFrom("mtwomey19@gmail.com");
        message.setTo(recipient);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message); // send message

        System.out.println("Confirmation email sent.");
    }
}
