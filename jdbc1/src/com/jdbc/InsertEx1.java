package com.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertEx1 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sudha@7878");
			st = con.createStatement();
			while (true) {
				System.out.print("Enter Customer Id :");
				int cid = Integer.parseInt(br.readLine());
				System.out.print("Enter Customer Name :");
				String cname = br.readLine();
				System.out.print("Enter Customer Address :");
				String caddr = br.readLine();
				st.executeUpdate("insert into customer values(" + cid + ",'" + cname + "','" + caddr + "')");
				System.out.println("Customer Data inserted successfully");
				String next = br.readLine();
				if (next.equals("no")) {
					break;
				}
			}
			con.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
