package com.bean;

import java.sql.Timestamp;

public class GroupB_Customer {
	private String customer_ID,ssn_ID,name;
	private int age;
	private String address1,address2,city,state,status,message;
	private Timestamp last_Updated;
	public GroupB_Customer() {
		super();
	}
	public GroupB_Customer(String customer_ID, String ssn_ID, String name,
			int age, String address1, String address2, String city,
			String state, String status, String message, Timestamp last_Updated) {
		super();
		this.customer_ID = customer_ID;
		this.ssn_ID = ssn_ID;
		this.name = name;
		this.age = age;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.status = status;
		this.message = message;
		this.last_Updated = last_Updated;
	}
	public String getCustomer_ID() {
		return customer_ID;
	}
	public void setCustomer_ID(String customer_ID) {
		this.customer_ID = customer_ID;
	}
	public String getSsn_ID() {
		return ssn_ID;
	}
	public void setSsn_ID(String ssn_ID) {
		this.ssn_ID = ssn_ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getLastUpdated() {
		return last_Updated;
	}
	public void setLastUpdated(Timestamp lastUpdated) {
		this.last_Updated = lastUpdated;
	}
	
	

}
