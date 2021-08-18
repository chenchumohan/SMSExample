package com.example.config;

import javax.mail.MessagingException;

import com.example.bean.Mail;
import com.example.bean.SmsPojo;

public interface MailService {
	//public Object sendEmail() throws MessagingException;

	public void sendEmail(SmsPojo sms);
}
