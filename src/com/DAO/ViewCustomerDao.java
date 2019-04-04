package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.util.DBTransaction;

public class ViewCustomerDao {

	public static ResultSet viewCustomer()
   {
	DBTransaction db=new DBTransaction();
	Connection con=db.getConnection();
	try{
		
		String sql="select ssn_id,status,message,last_updated from groupb_customer";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		return rs;
	
	}catch(SQLException e){
		e.printStackTrace();
	}
	return null;
   }
}
