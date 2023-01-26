package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateEx {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sudha@7878");
			st = con.createStatement();
			st.executeUpdate("update customer set cname='Jones' where cid=101");
			System.out.println("Customer Data updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
