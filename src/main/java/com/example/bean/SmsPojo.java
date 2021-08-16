package com.example.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "smsexample")
public class SmsPojo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_smsexample")
	@SequenceGenerator(name = "seq_smsexample", sequenceName = "seq_smsexample", allocationSize = 1)
	int SNO;
	String customer_details;
	 String phone_number;
	String comments;
	String order_details;
	String customer_requirments;
	public int getSNO() {
		return SNO;
	}
	public void setSNO(int sNO) {
		SNO = sNO;
	}
	public String getCustomer_details() {
		return customer_details;
	}
	public void setCustomer_details(String customer_details) {
		this.customer_details = customer_details;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getOrder_details() {
		return order_details;
	}
	public void setOrder_details(String order_details) {
		this.order_details = order_details;
	}
	public String getCustomer_requirments() {
		return customer_requirments;
	}
	public void setCustomer_requirments(String customer_requirments) {
		this.customer_requirments = customer_requirments;
	}
	
}
