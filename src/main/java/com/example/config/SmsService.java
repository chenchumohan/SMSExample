package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.example.bean.SmsPojo;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Component
public class SmsService {

	@Value("${ACCOUNT_SID}")
	private String ACCOUNT_SID;
	@Value("${AUTH_TOKEN}")
	private String AUTH_TOKEN;
	@Value("${FROM_NUMBER}")
	private String FROM_NUMBER;

	    public void send(SmsPojo sms) {
	    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	    	System.out.println("ACCOUNT_SID=====>"+ACCOUNT_SID);
	    	System.out.println("AUTH_TOKEN=====>"+AUTH_TOKEN);
	    	System.out.println("FROM_NUMBER=====>"+FROM_NUMBER);
	        Message message = Message.creator(new PhoneNumber(sms.getToNumber()), new PhoneNumber(FROM_NUMBER), sms.getTextMessage())
	                .create();
	    	        System.out.println("here is my id:"+message.getSid());
	    	        System.out.println("*********Message Sent Successfully***********");
	    }

	    public void receive(MultiValueMap<String, String> smscallback) {
	    }
	
}
