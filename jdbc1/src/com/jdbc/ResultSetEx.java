package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetEx {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sudha@7878");
			st = con.createStatement();
			rs = st.executeQuery("select * from customer");
			System.out.println("CID\tCNAME\tCADDR");
			System.out.println("--------------------");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
