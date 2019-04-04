package com.DAO;

import java.awt.List;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.DBTransaction;
import com.bean.GroupB_Transaction;



public class AccStatementDAO {
	DBTransaction db = new DBTransaction();
	Connection con = db.getConnection();
	
	
	public ArrayList<GroupB_Transaction> getStatement(String aid,int n) {
		ArrayList<GroupB_Transaction> al = new ArrayList<>();
		DBTransaction db = new DBTransaction();
		Connection con = db.getConnection();
		
		//String sql ="SELECT  * FROM MINISTATEMENT_GRPB WHERE ACCID=1";
		String sql = "SELECT * FROM "
				+ "(SELECT *FROM GroupB_Transaction WHERE ACCOUNT_ID=? ORDER BY LAST_UPDATED desc)"
				+ " WHERE rownum <= ? ORDER BY LAST_UPDATED DESC";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
		
		ps.setString(1, aid);
    	ps.setInt(2, n);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String transaction_ID = rs.getString(1);
			String account_ID = rs.getString(2);
			String transaction_Type = rs.getString(3);
			int amount = rs.getInt(4);
			String target_ID = rs.getString(5);
			Timestamp TransactionTime = rs.getTimestamp(6);
			GroupB_Transaction t = new  GroupB_Transaction(transaction_ID,account_ID,transaction_Type,amount,target_ID,TransactionTime);
	
				al.add(t)		;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}


	public ArrayList<GroupB_Transaction> getStatements(String aid, String sd, String ed) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<GroupB_Transaction> al = new ArrayList<>();
		DBTransaction db = new DBTransaction();
		Connection con = db.getConnection();
		sd = sd+"00:00:00.00";
		ed = ed+"23:59:59.99";
	

		String sql = "SELECT * FROM GroupB_Transaction WHERE Account_ID =? and "
				+ "Last_Updated BETWEEN TO_TIMESTAMP(?,'YYYY-MM-DD HH24:MI:SS.FF') AND "
				+ "TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS.FF')";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, aid);
		ps.setString(2, sd);
		ps.setString(3, ed);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String transaction_ID = rs.getString(1);
			String account_ID = rs.getString(2);
			String transaction_Type = rs.getString(3);
			int amount = rs.getInt(4);
			String target_ID = rs.getString(5);
			Timestamp TransactionTime = rs.getTimestamp(6);
			GroupB_Transaction t = new  GroupB_Transaction(transaction_ID,account_ID,transaction_Type,amount,target_ID,TransactionTime);
	
				al.add(t);
			}
		
		return al;
}
}
