package com.softvision.ecommerce.mail;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mail {
	private static final Logger logger = LoggerFactory.getLogger(Mail.class);
	private static final String USER_NAME = "stuti.pai@gmail.com";
	private static final String USER_PASS = "stuti@19961";

	public void sendMail(String key, HttpSession session) {
		String recipient = (String) session.getAttribute("emailId");
		String from = USER_NAME;
		String pass = USER_PASS;
		String[] to = { recipient };
		logger.info("dynamic  data of email:" + recipient);
		String subject = "Order Details";
		String body;
		if (key == "yes") {
			body = "Hello ,\nYour Order Has Been placed Successfully";
		}

		else {
			body = "Hello," + "\n Order unsuccessful!";
		}

		sendFromGMail(from, pass, to, subject, body);
	}

	private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {

		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(from));
			InternetAddress[] toAddress = new InternetAddress[to.length];
			for (int i = 0; i < to.length; i++) {
				toAddress[i] = new InternetAddress(to[i]);
			}
			for (int i = 0; i < toAddress.length; i++) {
				message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			}

			message.setSubject(subject);
			message.setContent(body, "text/html");
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			logger.info("Message sent succesfully...!!!");
			transport.close();
		} catch (AddressException ae) {
			logger.error("address Exception error");

		} catch (MessagingException me) {
			logger.error("MessagingException");

		}
	}
}