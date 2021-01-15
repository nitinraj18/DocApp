package com.springmvc.email;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
 
public interface SendEmailInterface {
	String sendMail(EmailDetails emailDetails)throws AddressException, MessagingException;
}