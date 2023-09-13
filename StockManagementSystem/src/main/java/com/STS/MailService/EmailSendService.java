package com.STS.MailService;

import org.springframework.stereotype.Service;

import com.STS.Entity.Customer;
import com.STS.Entity.StockManage;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;


@Service
public class EmailSendService {
    
    public void sendEmail(Customer customer, StockManage byproductByid) throws MessagingException {
        String toEmail = customer.getGmail();
        String subject = "Order Placed Successfully";
        
        String emailContent = "<html><body><h1>Order Placed Successfully</h1>" +
                "<h2>Customer Info:</h2>" +
                "<p><strong>Name:</strong> " + customer.getFirstname() + " " + customer.getLastname() + "</p>" +
                "<p><strong>Address:</strong> " + customer.getAddress() + "</p>" +
                "<p><strong>Phone Number:</strong> " + customer.getPhoneNo() + "</p>" +
                "<p><strong>Email:</strong> " + customer.getGmail() + "</p>" +
                "<h2>Product Info:</h2>" +
                "<table border='1' cellpadding='5' cellspacing='0'>" +
                "<tr><th>Product Name</th><th>Brand</th><th>Price</th><th>Date of Sale</th><th>Product Type</th></tr>" +
                "<tr>" +
                "<td>" + byproductByid.getProduct_name() + "</td>" +
                "<td>" + byproductByid.getProduct_brand() + "</td>" +
                "<td>" + byproductByid.getPrice() + "</td>" +
                "<td>" + byproductByid.getDateofSale() + "</td>" +
                "<td>" + byproductByid.getProduct_type() + "</td>" +
                "</tr>" +
                "</table></body></html>";

      
        JavaMailSender mailSender = new JavaMailSenderImpl();
        ((JavaMailSenderImpl) mailSender).setHost("smtp.gmail.com");
        ((JavaMailSenderImpl) mailSender).setPort(587);
        ((JavaMailSenderImpl) mailSender).setUsername("smrutiranjan.rapidsoft@gmail.com");
        ((JavaMailSenderImpl) mailSender).setPassword("euazxwycfrrdeggt");

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        ((JavaMailSenderImpl) mailSender).setJavaMailProperties(properties);
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("smrutiranjan.rapidsoft@gmail.com", "euazxwycfrrdeggt");
            }
        });

        MimeMessage message = new MimeMessage(session);

        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

            messageHelper.setFrom("smrutiranjan.rapidsoft@gmail.com");
            messageHelper.setTo(toEmail);
            messageHelper.setSubject(subject);

            messageHelper.setText(emailContent, true);

            ((JavaMailSenderImpl) mailSender).send(message);

            System.out.println("Mail sent successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }

}