package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTransaction {
	String url;
	Connection connection;
	String user;
	String password;
	
	
	

	
	public DBTransaction() {
		super();
		this.url = "jdbc:mysql://localhost:3306/mydb";
		this.user = "root";
		this.password = "root";
	}
	
	public Connection getConnection() {
		try {
			closeConnection();
			Class.forName("com.mysql.cj.jdbc.Driver");  
			connection = DriverManager.getConnection(url,user,password);
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			return connection;

	}
	public void closeConnection()
	{
		try
		{
			if(connection != null && connection.isClosed() == false)
				connection.close();
			connection = null;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
