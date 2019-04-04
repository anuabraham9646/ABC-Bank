package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBTransaction;

public class TransactionDAO {
	
	
	public static boolean withdraw(String account_ID, long amount){
		
		boolean flag=false;
		DBTransaction db= new DBTransaction();
		Connection con =db.getConnection();
		long new_balance;
		
		
		
		try {
			String check_status="Select status from GroupB_Account where account_ID like ?";
			PreparedStatement check_ps = con.prepareStatement(check_status);
			check_ps.setString(1, account_ID);
			ResultSet check_rs = check_ps.executeQuery();
			check_rs.next();
			String status= check_rs.getString(1);
			
			if(status.equalsIgnoreCase("active")){
			
			String selectString="Select balance from GroupB_Account where account_ID like ?";
			PreparedStatement ps1 = con.prepareStatement(selectString);
			ps1.setString(1, account_ID);
			ResultSet rs = ps1.executeQuery();
			rs.next();
			long balance = rs.getLong(1);
			//System.out.println(balance);
			
			
			
			if(balance>=amount){
				new_balance=balance-amount;
				flag=true;
			}
			else{
				return false;
			}
			String updateAcc = "Update GroupB_Account set balance = ?, last_Updated= current_timestamp where account_ID= ?";
			
			PreparedStatement ps2 = con.prepareStatement(updateAcc);
			ps2.setLong(1, new_balance);
			ps2.setString(2, account_ID);
			
			ps2.executeUpdate();
			
			String updateTranc = "Insert into GroupB_Transaction values (concat('T',groupb_customersequence.nextval),?,?,?,?,current_timestamp)";
			
			PreparedStatement ps3 = con.prepareStatement(updateTranc);
			ps3.setString(1, account_ID);
			ps3.setString(2, "Withdraw");
			ps3.setLong(3, amount);
			ps3.setString(4, account_ID);
			
			ps3.executeUpdate();
			
			}
			else{
				System.out.println("Account Inactive");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
		
	}
	
	
	
	public static boolean deposit(String account_ID, long amount){
		
		boolean flag=false;
		DBTransaction db= new DBTransaction();
		Connection con =db.getConnection();
		long new_balance;
		
		
		
		try {
			String check_status="Select status from GroupB_Account where account_ID like ?";
			PreparedStatement check_ps = con.prepareStatement(check_status);
			check_ps.setString(1, account_ID);
			ResultSet check_rs = check_ps.executeQuery();
			check_rs.next();
			String status= check_rs.getString(1);
			
			if(status.equalsIgnoreCase("active")){
			
			String selectString="Select balance from GroupB_Account where account_ID like ?";
			PreparedStatement ps1 = con.prepareStatement(selectString);
			ps1.setString(1, account_ID);
			ResultSet rs = ps1.executeQuery();
			rs.next();
			long balance = rs.getLong(1);
			//System.out.println(balance);
			
			
			new_balance=balance+amount;
			
			String updateAcc = "Update GroupB_Account set balance = ?, last_Updated= current_timestamp where account_ID= ?";
			
			PreparedStatement ps2 = con.prepareStatement(updateAcc);
			ps2.setLong(1, new_balance);
			ps2.setString(2, account_ID);
			
			ps2.executeUpdate();
			
			
			String updateTranc = "Insert into GroupB_Transaction values (concat('T',groupb_customersequence.nextval),?,?,?,?,current_timestamp)";
			
			PreparedStatement ps3 = con.prepareStatement(updateTranc);
			ps3.setString(1, account_ID);
			ps3.setString(2, "Deposit");
			ps3.setLong(3, amount);
			ps3.setString(4, account_ID);
			
			ps3.executeUpdate();
			
			flag=true;
			
			}
			else{
				System.out.println("Account Inactive");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	
	public static boolean transfer(String account_ID1,String account_ID2, long amount){
		
		boolean flag=false;
		DBTransaction db= new DBTransaction();
		Connection con =db.getConnection();
		
		
		try {
			String check_status1="Select status from GroupB_Account where account_ID like ?";
			PreparedStatement check_ps1 = con.prepareStatement(check_status1);
			check_ps1.setString(1, account_ID1);
			ResultSet check_rs1 = check_ps1.executeQuery();
			check_rs1.next();
			String status1= check_rs1.getString(1);
			
			String check_status2="Select status from GroupB_Account where account_ID like ?";
			PreparedStatement check_ps2 = con.prepareStatement(check_status2);
			check_ps2.setString(1, account_ID2);
			ResultSet check_rs2 = check_ps2.executeQuery();
			check_rs2.next();
			String status2;
			try {
				status2 = check_rs2.getString(1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return false;
			}
			
			
			if(status1.equalsIgnoreCase("active")&&status2.equalsIgnoreCase("active")){
			
			
			String selectString1="Select balance from GroupB_Account where account_ID like ?";
			PreparedStatement ps1 = con.prepareStatement(selectString1);
			ps1.setString(1, account_ID1);
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			long balance1 = rs1.getLong(1);
			//System.out.println(balance);
			
			
			String selectString2="Select balance from GroupB_Account where account_ID like ?";
		
				PreparedStatement ps2 = con.prepareStatement(selectString2);
				ps2.setString(1, account_ID2);
				ResultSet rs2 = ps2.executeQuery();
				rs2.next();
				long balance2 = rs2.getLong(1);
				//System.out.println(balance);
			
			
			
			if(balance1>=amount){
				balance1=balance1-amount;
				balance2+=amount;
				flag=true;
			}
			else{
				System.out.println("not enough balance");
				return false;
			}
				
			
			String updateAcc1 = "Update GroupB_Account set balance = ?, last_Updated= current_timestamp where account_ID= ?";
			
			PreparedStatement ps3 = con.prepareStatement(updateAcc1);
			ps3.setLong(1, balance1);
			ps3.setString(2, account_ID1);
			
			ps3.executeUpdate();
			
			String updateTranc = "Insert into GroupB_Transaction values (concat('T',groupb_customersequence.nextval),?,?,?,?,current_timestamp)";
			
			PreparedStatement ps4 = con.prepareStatement(updateTranc);
			ps4.setString(1, account_ID1);
			ps4.setString(2, "Transfer debited");
			ps4.setLong(3, amount);
			ps4.setString(4, account_ID2);
			
			ps4.executeUpdate();
			
			
			
			String updateAcc2 = "Update GroupB_Account set balance = ?, last_Updated= current_timestamp where account_ID= ?";
			
			PreparedStatement ps5 = con.prepareStatement(updateAcc2);
			ps5.setLong(1, balance2);
			ps5.setString(2, account_ID2);
			
			ps5.executeUpdate();
			
			String updateTranc1 = "Insert into GroupB_Transaction values (concat('T',groupb_customersequence.nextval),?,?,?,?,current_timestamp)";
			
			PreparedStatement ps6 = con.prepareStatement(updateTranc1);
			ps6.setString(1, account_ID2);
			ps6.setString(2, "Transfer credited");
			ps6.setLong(3, amount);
			ps6.setString(4, account_ID1);
			
			ps6.executeUpdate();
			
			
			}
			else{
				if(status1.equalsIgnoreCase("inactive"))
					System.out.println("Oops! The account "+account_ID1+" is inactive");
				else
					System.out.println("Oops! The account "+account_ID2+" is inactive");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
		
		
	}
	

}

