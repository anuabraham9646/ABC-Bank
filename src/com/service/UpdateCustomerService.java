package com.service;

import java.sql.ResultSet;

import com.DAO.UpdateCustomerDAO;
import com.util.DBTransaction;

public class UpdateCustomerService {
	UpdateCustomerDAO dao = new UpdateCustomerDAO();
	DBTransaction db= new DBTransaction();
	
	
	public ResultSet searchCustomer(String customer_ID){
		ResultSet user = UpdateCustomerDAO.searchCustomer(db,customer_ID);
		return user;

	}
	public int updateCustomer(String customer_ID,String name, int age, String address1,String address2, String city, String state){
		int found= 0;
		found = UpdateCustomerDAO.updateCustomer(db,customer_ID,name, age, address1, address2, city, state);
		return found;
		
	}
	public int deleteCustomer(String customer_ID) {
		int deleted=0;
		deleted = UpdateCustomerDAO.deleteCustomer(db,customer_ID);
		return deleted;
			
		}
}
