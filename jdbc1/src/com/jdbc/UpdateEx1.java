package com.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateEx1 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sudha@7878");
			st = con.createStatement();
			System.out.println("Enter Customer name :");
			String cname = br.readLine();
			System.out.println("Enter Customer Id :");
			int cid = Integer.parseInt(br.readLine());
			st.executeUpdate("update customer set cname='"+cname+"' where cid="+cid+"");
			System.out.println("Customer Data updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
