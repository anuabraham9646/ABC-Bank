package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBTransaction;

public class DeleteAccountDao {
	static DBTransaction db=new DBTransaction();
	public static ResultSet viewAccountSSN(String id)
	{ResultSet rs,rs1=null;
	Connection con = null;
		try {
			con=db.getConnection();
			PreparedStatement ps=con.prepareStatement("Select customer_id from groupb_customer where SSN_id=?");
			ps.setString(1,id);
			rs=ps.executeQuery();
			rs.next();
			System.out.println(rs.getString("customer_id"));
			PreparedStatement ps1=con.prepareStatement("Select * from groupb_account where customer_id=?");
			ps1.setString(1,rs.getString("customer_id"));
			rs1=ps1.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return rs1;	
	}
public static ResultSet viewAccountID(String id)
	{ResultSet rs=null;
	Connection con = null;
		try {
			con=db.getConnection();
			PreparedStatement ps=con.prepareStatement("Select * from groupb_account where Customer_ID=?");
			ps.setString(1,id);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return rs;	
	}
	
	public static int deleteAccount(String id)
	{
		int update_successful=0;
	Connection con = null;
		try {
			con=db.getConnection();
			PreparedStatement ps=con.prepareStatement("update groupb_account set message=?,status=?,last_updated=current_timestamp where account_id=?");
			ps.setString(1,"Account Deletion Successful");
			ps.setString(2,"INACTIVE");
			ps.setString(3,id);
			update_successful=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update_successful;
	}
}
