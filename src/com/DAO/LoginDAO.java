package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.util.DBTransaction;

public class LoginDAO {

	public static boolean loginUser(DBTransaction db,String user_ID,String password){
		Connection con =db.getConnection();
		
		try {
			//PreparedStatement ps = con.prepareStatement("select * from GroupB_Login where user_ID = '"+ user_ID+"' and password = '"+ password+"'");
		//	SELECT * from GroupB_Login WHERE user_ID='" + user_ID + "' and password='"password"'";" +
			//PreparedStatement ps = con.prepareStatement("SELECT * from GroupB_Login WHERE user_ID='" + user_ID + "' and password='"password"'";
			/*ps.setString(1, user_ID);
			ps.setString(2, password);*/
			
			String sqlString = "SELECT * from GroupB_Login WHERE user_ID=? and password=?";
		//	System.out.println("hi");
			//System.out.println(con);
			PreparedStatement ps = con.prepareStatement(sqlString);
			ps.setString(1, user_ID);
			ps.setString(2, password);
			ResultSet user=ps.executeQuery();
		//System.out.println(user);
		if(user.next()){
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
