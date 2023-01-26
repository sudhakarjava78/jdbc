package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PreparedStatementEx {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sudha@7878");
			PreparedStatement pst = con.prepareStatement("insert into customer values(?,?,?)");
			pst.setInt(1, 103);
			pst.setString(2, "RC");
			pst.setString(3, "Hyd");
			int rowCount=pst.executeUpdate();
			if(rowCount == 1) {
				System.out.println("Insertion Success");
			}else {
				System.out.println("Insertion Failure");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
