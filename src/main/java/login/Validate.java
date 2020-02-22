package login;

import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import configDB.JDBC;

public class Validate {
	// this is validate class
	static String confirmCode = "";

	public static void sendMail(String receiver) {
		final String userName = "projectlibary84@gmail.com";
		final String password = "P@ssw0rd2019";

		// Get system properties
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName, "L_RUPP"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			message.setSubject("You have been requrest for verification code");
			message.setText("confirm code : " + getconfirmCode());

			Transport.send(message);
		} catch (Exception m) {
			m.printStackTrace();
		}
	}

	public static String getconfirmCode() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		confirmCode = String.format("%06d", number);
		return String.format("%06d", number);
	}

	static ArrayList<String> getUserName(String userName) {

		try {
			ArrayList<ArrayList<String>> user = JDBC.readBy("secuser", "username", userName);
			System.out.println(user);
			if (user.size() > 0) {
				return user.get(0);
			} else {
				Logger logger = Logger.getLogger("UserName not found");
			}

		} catch (SQLException e) {
			Logger logger = Logger.getLogger("UserName not found");
		}

		return null;
	}

	static String getFullName() {
	
		
		return new String();
	}
}
