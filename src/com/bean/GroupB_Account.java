package com.bean;

import java.sql.Timestamp;

public class GroupB_Account {
	private String account_ID,customer_ID,account_Type;
	private int balance;
	private String status, message;
	private Timestamp last_Updated;
	public GroupB_Account() {
		super();
	}
	public GroupB_Account(String account_ID, String customer_ID,
			String account_Type, int balance, String status, String message,
			Timestamp last_Updated) {
		super();
		this.account_ID = account_ID;
		this.customer_ID = customer_ID;
		this.account_Type = account_Type;
		this.balance = balance;
		this.status = status;
		this.message = message;
		this.last_Updated = last_Updated;
	}
	public String getAccount_ID() {
		return account_ID;
	}
	public void setAccount_ID(String account_ID) {
		this.account_ID = account_ID;
	}
	public String getCustomer_ID() {
		return customer_ID;
	}
	public void setCustomer_ID(String customer_ID) {
		this.customer_ID = customer_ID;
	}
	public String getAccount_Type() {
		return account_Type;
	}
	public void setAccount_Type(String account_Type) {
		this.account_Type = account_Type;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
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
	public Timestamp getLast_Updated() {
		return last_Updated;
	}
	public void setLast_Updated(Timestamp last_Updated) {
		this.last_Updated = last_Updated;
	}
	

}
