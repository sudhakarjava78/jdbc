package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertEx {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sudha@7878");
			Statement st = con.createStatement();
			st.executeUpdate("insert into customer values(101,'Sam','USA')");
			System.out.println("Customer Data inserted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
