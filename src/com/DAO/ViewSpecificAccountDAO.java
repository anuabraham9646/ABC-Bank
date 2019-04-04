package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBTransaction;

public class ViewSpecificAccountDAO {

	public static ResultSet searchCustomer(DBTransaction db, String id) {
		Connection con =db.getConnection();
	try {	if(id.charAt(0)==('C')||id.charAt(0)==('S')){
			
				//System.out.println("heyy");
				String sqlString = "SELECT * from GroupB_Account WHERE account_ID=?";
				PreparedStatement ps = con.prepareStatement(sqlString);
				ps.setString(1, id);	
				
				ResultSet account=ps.executeQuery();System.out.println(account);
			return account;
		
			}
		else if(id.charAt(0)==('U')){
			System.out.println("u aagya");
			String sqlString = "SELECT * from GroupB_Account WHERE customer_ID=?";
			PreparedStatement ps = con.prepareStatement(sqlString);
			//ps.setString(1, id);	
			ps.setString(1,id);
			ResultSet account=ps.executeQuery();System.out.println(account);
		return account;
			
	}
		else{
			String sqlString = "SELECT customer_ID from GroupB_Customer WHERE SSN_ID=?";
			PreparedStatement ps = con.prepareStatement(sqlString);
			ps.setString(1, id);	
			
			ResultSet user=ps.executeQuery();
			user.next();
			String sqlString1 = "SELECT * from GroupB_Account WHERE customer_ID=?";
			PreparedStatement ps1 = con.prepareStatement(sqlString1);
			ps1.setString(1, user.getString("customer_ID"));	
			
			ResultSet account=ps1.executeQuery();
			
		return account;
			
		}
		} catch (SQLException e) {
				e.printStackTrace();
				ResultSet user=null;
				return user;
			}
		}

	public ResultSet getCustomercust(DBTransaction db, String customer_ID) {
		// TODO Auto-generated method stub
		return null;
	}
			
		}
		
		
	

