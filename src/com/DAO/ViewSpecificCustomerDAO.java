package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBTransaction;

public class ViewSpecificCustomerDAO {

	public ResultSet getCustomerssn(DBTransaction db, String ssn_ID) {
Connection con =db.getConnection();
		
		try {
		
			String sqlString = "SELECT ssn_id,customer_id,name,address1,age from GroupB_Customer WHERE ssn_ID=?";
			PreparedStatement ps = con.prepareStatement(sqlString);
			ps.setString(1, ssn_ID);			
			ResultSet user=ps.executeQuery();
		return user;
	
		} catch (SQLException e) {
			e.printStackTrace();
			ResultSet user=null;
			return user;
		}
	}

	public ResultSet getCustomercust(DBTransaction db, String customer_ID) {
Connection con =db.getConnection();
		
		try {
		
			String sqlString = "SELECT ssn_id,customer_id,name,address1,age from GroupB_Customer WHERE customer_ID=?";
			PreparedStatement ps = con.prepareStatement(sqlString);
			ps.setString(1, customer_ID);			
			ResultSet user=ps.executeQuery();
		return user;
	
		} catch (SQLException e) {
			e.printStackTrace();
			ResultSet user=null;
			return user;
		}
	}

}
