package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBTransaction;

public class UpdateCustomerDAO {

	public static ResultSet searchCustomer(DBTransaction db, String customer_ID) {
		Connection con =db.getConnection();
		
		try {
		
			String sqlString = "SELECT * from GroupB_Customer WHERE customer_ID=?";
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

	public static int updateCustomer(DBTransaction db, String customer_ID, String name,int age, String address1, String address2, String city, String state) {
		Connection con =db.getConnection();
		int found= 0;


		
		try {
	
			String sqlString = "update GroupB_Customer set name=?, age=?, address1=?, address2=?, city=?, state=?, last_Updated=CURRENT_TIMESTAMP WHERE customer_ID=?";

			PreparedStatement ps = con.prepareStatement(sqlString);
			System.out.println(ps);
			ps.setString(1,name);
			ps.setInt(2,age);
			ps.setString(3,address1);
			ps.setString(4,address2);
			ps.setString(5,city);
			ps.setString(6,state);
			System.out.println(ps);
			ps.setString(7,customer_ID);
			
			
			
			found=ps.executeUpdate();
			//System.out.println("found="+found);
		
			return found;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return 0;
		}
	}

	public static int deleteCustomer(DBTransaction db, String customer_ID) {
		Connection con =db.getConnection();
		int deleted= 0;
		int delupdate=0;
		try {
			
			String sqlString = "update GroupB_Customer set last_Updated=CURRENT_TIMESTAMP,status=?,message=? WHERE customer_ID=?";
			String status="INACTIVE";
			String message="Account deactivated";
			PreparedStatement ps = con.prepareStatement(sqlString);
			System.out.println(ps);
			ps.setString(1,status);
			
			ps.setString(2,message);
			System.out.println(ps);
			ps.setString(3,customer_ID);
			
			
			//System.out.println(ps);
			deleted=ps.executeUpdate();
			//System.out.println("found="+found);
			
			
			String sqlString12 = "update GroupB_Account set last_Updated=CURRENT_TIMESTAMP,status=?,message=? WHERE customer_ID=?";
			String status1="INACTIVE";
			String message1="Account deactivated";
			PreparedStatement ps1 = con.prepareStatement(sqlString12);
			System.out.println(ps1);
			ps1.setString(1,status1);
			
			ps1.setString(2,message1);
			System.out.println(ps);
			System.out.println(customer_ID);
			ps1.setString(3,customer_ID);
			
			
			//System.out.println(ps);
			delupdate=ps1.executeUpdate();
			System.out.println(delupdate+"heyyy");
			return deleted;	
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return 0;
		}
	}
	}




