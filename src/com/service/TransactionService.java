package com.service;

import com.DAO.TransactionDAO;

public class TransactionService {
	
	public boolean withdraw_serv(String account_ID, long amount){
		
		
		if(TransactionDAO.withdraw(account_ID,amount))
			return true;
		else
			return false;
		
	}
	
	public boolean deposit_serv(String account_ID, long amount){
		
		
		if(TransactionDAO.deposit(account_ID,amount))
			return true;
		else
			return false;
		
	}
	
	
	public boolean transfer_serv(String account_ID1,String account_ID2, long amount){
		
		
		if(TransactionDAO.transfer(account_ID1,account_ID2,amount))
			return true;
		else
			return false;
		
	}
	

}
