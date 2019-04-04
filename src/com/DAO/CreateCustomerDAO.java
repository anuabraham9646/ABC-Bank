package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBTransaction;

public class CreateCustomerDAO {
	public static boolean createCustomer(DBTransaction db,String ssn_ID,String name,int age,String address1,String address2,String city,String state){
		Connection con =db.getConnection();
	/*	System.out.println(ssn_ID);
		System.out.println(name);
		System.out.println(age);
		System.out.println(address1);
		System.out.println(address2);
		System.out.println(city);
		System.out.println(state);*/
		
		try {
			
			String msg="Creation";
			String status="Creation initaited";
			String sqlString="insert into GroupB_Customer (customer_id, ssn_ID, name, age, address1, address2, city, state, status, message, last_updated ) values (concat('U',groupb_customersequence.nextval),?,?,?,?,?,?,?,?,?,CURRENT_TIMESTAMP)";
		
			PreparedStatement ps = con.prepareStatement(sqlString);
			
			ps.setString(1,ssn_ID);
			ps.setString(2,name);
			ps.setInt(3,age);
			ps.setString(4,address1);
			ps.setString(5,address2);
			ps.setString(6,city);
			ps.setString(7,state);
			ps.setString(8,status);
			ps.setString(9,msg);
		
			int record=ps.executeUpdate();
		
		if(record ==1){
			return true;
		}
		else{
			return false;
		}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


}
