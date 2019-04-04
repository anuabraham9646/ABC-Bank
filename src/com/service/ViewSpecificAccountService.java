package com.service;

import java.sql.ResultSet;

import com.DAO.ViewSpecificAccountDAO;
import com.util.DBTransaction;

public class ViewSpecificAccountService {

	public ResultSet viewSpecificAccount(String id){
		
		DBTransaction db= new DBTransaction();
		ResultSet account = ViewSpecificAccountDAO.searchCustomer(db,id);
		return account;
	}
}
