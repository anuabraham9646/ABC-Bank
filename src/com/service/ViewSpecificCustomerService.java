package com.service;

import java.sql.ResultSet;

import com.DAO.ViewSpecificCustomerDAO;
import com.util.DBTransaction;

public class ViewSpecificCustomerService {
	DBTransaction db= new DBTransaction();
	ViewSpecificCustomerDAO dao= new ViewSpecificCustomerDAO();

	public ResultSet searchCustomerssn(String ssn_ID) {
		ResultSet rs=dao.getCustomerssn(db,ssn_ID);
		return rs;
		// TODO Auto-generated method stub
		
	}

	public ResultSet searchCustomercust(String customer_ID) {
		ResultSet rs1=dao.getCustomercust(db,customer_ID);
		return rs1;
		// TODO Auto-generated method stub
		
	}
}

