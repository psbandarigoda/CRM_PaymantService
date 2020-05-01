package com.payment.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	
	
public static Connection connect() {
		
	
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CRMPaymentService", "root", "mysql");
			System.out.println("Database Connected");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	
}
	
}
