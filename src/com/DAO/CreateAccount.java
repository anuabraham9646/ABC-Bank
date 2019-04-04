package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBTransaction;

public class CreateAccount {
	public static boolean createAccount(DBTransaction db,String CID,String sa_ca,double DA){
		Connection con =db.getConnection();
		int search=0;
		System.out.println(CID);
		System.out.println(sa_ca);
		System.out.println(DA);
		
		try {
			
			String sqlString1 = "select * from GroupB_Customer WHERE customer_ID=?";
			PreparedStatement ps = con.prepareStatement(sqlString1);
			System.out.println(ps);

			ps.setString(1,CID);
			
			
			//System.out.println(ps);
			search=ps.executeUpdate();
			ResultSet rs=ps.executeQuery();
			rs.next();
			if(rs.getString("status").equalsIgnoreCase("inactive")){
				System.out.println("Such customer doesnt exist create an account first");
				return false;
			}
			
			else{
				if(search==1){
					
					try {
						
						if (sa_ca.equals("ca")) {
							String msg = "Account creation initiated successfully";
							String status = "active";
							String sqlString = "insert into GroupB_Account (account_ID,customer_ID,account_Type,balance,status,message,last_Updated) values (concat('C',groupb_customersequence.nextval),?,?,?,?,?,CURRENT_TIMESTAMP)";
							PreparedStatement ps1 = con.prepareStatement(sqlString);
							ps1.setString(1, CID);
							ps1.setString(2, sa_ca);
							ps1.setDouble(3, DA);
							ps1.setString(4, status);
							ps1.setString(5, msg);
							int record = ps1.executeUpdate();
							if (record == 1) {
								return true;
							} else {
								return false;
							}
						}
						else if(sa_ca.equals("sa")){
							String msg = "Account creation initiated successfully";
							String status = "active";
							String sqlString = "insert into GroupB_Account (account_ID,customer_ID,account_Type,balance,status,message,last_Updated) values (concat('S',groupb_customersequence.nextval),?,?,?,?,?,CURRENT_TIMESTAMP)";
							PreparedStatement ps1 = con.prepareStatement(sqlString);
							ps1.setString(1, CID);
							ps1.setString(2, sa_ca);
							ps1.setDouble(3, DA);
							ps1.setString(4, status);
							ps1.setString(5, msg);
							int record = ps1.executeUpdate();
							if (record == 1) {
								return true;
							} else {
								return false;
							}
							
						}
						
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return false;
					}
				}
				else{
					System.out.println("Such customer doesnt exist create an account first");
					return false;
				}
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return false;
	}


}
