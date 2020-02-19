package login;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Validate {
	//this is validate class

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
			message.setText("confirm code : "+getconfirmCode());
			
			Transport.send(message);
		} catch (Exception m) {
			m.printStackTrace();
		}
	}
	
	public static String getconfirmCode() {
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);
	    return String.format("%06d", number);
	}
}
