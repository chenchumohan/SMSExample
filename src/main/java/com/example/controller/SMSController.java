package com.example.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.SmsPojo;
import com.example.config.MailService;
import com.example.config.SmsService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({ "/smsExample" })
public class SMSController {

	@Autowired
    private SmsService service;

    @Autowired
    private SimpMessagingTemplate webSocket;
    @Autowired
    private MailService mailService;
    private final String  TOPIC_DESTINATION = "/lesson/sms";

    @RequestMapping(path = { "/sms" }, method = RequestMethod.POST,consumes="application/json", produces = "application/json")
    public SmsPojo smsSubmit(@RequestBody SmsPojo sms) throws Exception {
        try{
        	System.out.println("sms======>"+sms.getPhone_number());
        	System.out.println("sms==message====>"+sms.getComments());
        	System.out.println("sms===Customer Details===>"+sms.getCustomer_details());
        	System.out.println("sms==Customer Requirements====>"+sms.getCustomer_requirments());
        	System.out.println("sms==Order Details====>"+sms.getOrder_details());
            service.send(sms);
            mailService.sendEmail(sms);
        }
        catch(Exception e){

            webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": Error sending the SMS: "+e.getMessage());
            throw e;
        }
        webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": SMS has been sent!: "+sms.getPhone_number());
        System.out.println("webSocket===>"+getTimeStamp());
		return sms;

    }


    private String getTimeStamp() {
       return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }
	/*
	 * @GetMapping("/sendEmail") public Object sendEMail() throws MessagingException
	 * { System.out.println("========sendEmail==="); return mailService.sendEmail();
	 * 
	 * }
	 */
}
