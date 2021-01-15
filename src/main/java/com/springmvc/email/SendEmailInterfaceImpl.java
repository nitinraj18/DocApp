package com.springmvc.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.sun.mail.smtp.SMTPTransport;

@Component
@PropertySource("classpath:static/Email.properties")
public class SendEmailInterfaceImpl implements SendEmailInterface{
	final static public String SENT_STATUS = "SENT";

	//For getting value from properties file
	@Autowired
	private Environment environment;

	
	public String sendMail(EmailDetails emailDetails)
			throws AddressException, MessagingException {
         System.out.println("");
		if(emailDetails==null)
		{
			return "Email details are not set";
		}

		Properties prop = System.getProperties();

		prop.put("mail.transport.protocol", "smtp");
	    prop.put("mail.smtp.auth", "true");
	    prop.put("mail.smtp.starttls.enable", "true");
	    prop.put("mail.debug", "true");
		
		
		
		Session session = Session.getInstance(prop, null);
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress("nitintestemailfunction@gmail.com"));

		if(emailDetails.getToList()==null)
		{
			return "To receipent are not present";
		}

		//Set to receipent list
		msg.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(emailDetails.getToList(), false));

				
		if(emailDetails.getEmailSubject()==null)
		{
			return "Email has no subject";
		}

		msg.setSubject(emailDetails.getEmailSubject());

		//Set email body 
		Multipart mp = new MimeMultipart();


		//Check if email has body
		if(emailDetails.getEmailBody()==null)
		{
			return "Email has no body";
		}

		//if email body is present then add to multipart 
		MimeBodyPart p1 = new MimeBodyPart();
		p1.setText(emailDetails.getEmailBody());
		mp.addBodyPart(p1);

		
		//Send mail
		SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
		// connect
		t.connect(environment.getProperty("host_name"), environment.getProperty("username"), environment.getProperty("password"));
		// send
		t.sendMessage(msg, msg.getAllRecipients());
		System.out.println("Response: " + t.getLastServerResponse());
		t.close();

		return SENT_STATUS;
	}
	
}