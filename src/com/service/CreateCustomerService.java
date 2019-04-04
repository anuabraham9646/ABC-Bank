package com.service;

import com.DAO.CreateCustomerDAO;
import com.util.DBTransaction;

public class CreateCustomerService {
	CreateCustomerDAO dao = new CreateCustomerDAO();
	DBTransaction db= new DBTransaction();
	public boolean CreateUser(String ssn_ID,String name,int age,String address1,String address2,String city,String state){
		
		boolean found= false;
		found = CreateCustomerDAO.createCustomer(db, ssn_ID, name, age, address1, address2, city, state);
		
		return found;

}
}
