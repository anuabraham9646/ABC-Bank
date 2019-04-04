package com.bean;

import java.sql.Timestamp;

public class GroupB_Transaction {
	private String transaction_ID,account_ID,transaction_Type;
	private int amount;
	private String target_ID;
	private Timestamp TransactionTime;
	public GroupB_Transaction() {
		super();
	}
	public GroupB_Transaction(String transaction_ID, String account_ID,
			String transaction_Type, int amount, String target_ID,
			Timestamp transactionTime) {
		super();
		this.transaction_ID = transaction_ID;
		this.account_ID = account_ID;
		this.transaction_Type = transaction_Type;
		this.amount = amount;
		this.target_ID = target_ID;
		TransactionTime = transactionTime;
	}
	public String getTransaction_ID() {
		return transaction_ID;
	}
	public void setTransaction_ID(String transaction_ID) {
		this.transaction_ID = transaction_ID;
	}
	public String getAccount_ID() {
		return account_ID;
	}
	public void setAccount_ID(String account_ID) {
		this.account_ID = account_ID;
	}
	public String getTransaction_Type() {
		return transaction_Type;
	}
	public void setTransaction_Type(String transaction_Type) {
		this.transaction_Type = transaction_Type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getTarget_ID() {
		return target_ID;
	}
	public void setTarget_ID(String target_ID) {
		this.target_ID = target_ID;
	}
	public Timestamp getTransactionTime() {
		return TransactionTime;
	}
	public void setTransactionTime(Timestamp transactionTime) {
		TransactionTime = transactionTime;
	}
	

}
