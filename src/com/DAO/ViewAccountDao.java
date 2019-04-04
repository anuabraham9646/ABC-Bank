package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBTransaction;

public class ViewAccountDao {

	public static ResultSet viewAccount()
	   {
		DBTransaction db=new DBTransaction();
		Connection con=db.getConnection();
		try{
			String sql="select Customer_id,account_type,status,message,last_updated from groupb_account";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			return rs;
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	   }
}
