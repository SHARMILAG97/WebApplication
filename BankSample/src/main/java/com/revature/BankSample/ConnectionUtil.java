package com.revature.BankSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public static Connection getConnection() {
		
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/BankApplication";
		String username = "root";
		String password = "ROOT";
		
		Connection con = null;
		
		try {
			
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url,username,password);
		}
		
		catch(ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
	
		}
		
		
		return con;
		
	}

}
