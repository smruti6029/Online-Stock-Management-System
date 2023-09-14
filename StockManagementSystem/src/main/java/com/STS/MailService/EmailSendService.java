package com.STS.MailService;

import org.springframework.stereotype.Service;

import com.STS.DTO.CustumerInvoiceGenerateDto;
import com.STS.Entity.Customer;
import com.STS.Entity.StockManage;
import com.STS.pdf.Datamaper;
import com.STS.pdf.DocumentGEnerator;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class EmailSendService {

	@Autowired
	private JavaMailSender mailSender;
	

	@Autowired
	private Datamaper datamaper;

	public void sendEmail(Customer customer, StockManage byproductByid) throws Exception {
		String toEmail = customer.getGmail();
		String subject = "Order Placed Successfully";

		String emailContent = "<html><body><h1>Order Placed Successfully</h1>" + "<h2>Customer Info:</h2>"
				+ "<p><strong>Name:</strong> " + customer.getFirstname() + " " + customer.getLastname() + "</p>"
				+ "<p><strong>Address:</strong> " + customer.getAddress() + "</p>"
				+ "<p><strong>Phone Number:</strong> " + customer.getPhoneNo() + "</p>" + "<p><strong>Email:</strong> "
				+ customer.getGmail() + "</p>" + "<h2>Product Info:</h2>"
				+ "<table border='1' cellpadding='5' cellspacing='0'>"
				+ "<tr><th>Product Name</th><th>Brand</th><th>Price</th><th>Date of Sale</th><th>Product Type</th></tr>"
				+ "<tr>" + "<td>" + byproductByid.getProduct_name() + "</td>" + "<td>"
				+ byproductByid.getProduct_brand() + "</td>" + "<td>" + byproductByid.getPrice() + "</td>" + "<td>"
				+ byproductByid.getDateofSale() + "</td>" + "<td>" + byproductByid.getProduct_type() + "</td>" + "</tr>"
				+ "</table></body></html>";
		
		
		CustumerInvoiceGenerateDto custumerInvoiceGenerateDto = new CustumerInvoiceGenerateDto();
		
		CustumerInvoiceGenerateDto convertForPdf = custumerInvoiceGenerateDto.convertForPdf(byproductByid,customer);
		
			Pdfgenerate pdfgenerate = new Pdfgenerate();
			
//			pdfgenerate.generatePdf(byproductByid);
			
			datamaper.setData(convertForPdf);

		MimeMessage message = mailSender.createMimeMessage();

		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom("smruti97761@gmail.com");
			messageHelper.setTo(toEmail);
			messageHelper.setSubject(subject);
//			messageHelper.setText(emailContent, true);
			MimeBodyPart part1=new MimeBodyPart();
			part1.setText(emailContent);
			
			MimeBodyPart part2=new MimeBodyPart();
			
//			File file=new File("/home/rapidsoft/Desktop/Passport Me.jpeg");
			File file=new File("/home/rapidsoft/invoice.pdf");
			part2.attachFile(file);
			
			MimeMultipart mimeMultipart=new MimeMultipart();
			mimeMultipart.addBodyPart(part1);
			mimeMultipart.addBodyPart(part2);
			
			message.setContent(mimeMultipart);	
			

			((JavaMailSenderImpl) mailSender).send(message);

			System.out.println("Mail sent successfully");
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("Failed to send email: " + e.getMessage());
		}
	}

}