package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {

	public static void main(String[] args) {
		Connection con = null;

		try {
			// Load and Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Establish the Connection
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sudha@7878");
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				System.out.println("finally block");
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

	}

}
