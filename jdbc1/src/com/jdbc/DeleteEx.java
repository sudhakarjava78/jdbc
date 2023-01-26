package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteEx {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sudha@7878");
			st = con.createStatement();
			//st.executeUpdate("delete from customer where cid=103");
			st.executeUpdate("drop table customer");
			System.out.println("Customer table deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
