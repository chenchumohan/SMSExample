package com.example.config;

import java.io.UnsupportedEncodingException;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import com.example.bean.Mail;
import com.example.bean.SmsPojo;

@Service("mailService")
public class MailServiceImpl implements MailService {
 
    @Autowired
    JavaMailSender mailSender;
  
    @Value("${spring.mail.mailSubject}")
	private String mailSubject;
    @Value("${spring.mail.mailContent}")
	private String mailContent;
    @Value("${spring.mail.username}")
	private String mailFrom;
    @Value("${spring.mail.to}")
	private String mailTo;
 
    public void sendEmail(SmsPojo sms) {
    	System.out.println("send meail message====>"+sms.getComments());
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mailTo);
        msg.setFrom(mailFrom);
        msg.setSubject(mailSubject);
        msg.setText(sms.getComments());
        mailSender.send(msg);
        System.out.println("Mail sent successfully===>"+msg);
		return;
      }
}
