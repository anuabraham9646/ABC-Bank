package com.service;

import com.DAO.LoginDAO;
import com.util.DBTransaction;

public class BankService {
	LoginDAO dao = new LoginDAO();
	DBTransaction db= new DBTransaction();
	public boolean loginUser(String user_ID,String password){
		
		boolean found= false;
		found = LoginDAO.loginUser(db,user_ID,password);
		
		return found;
		
		
	}

}
