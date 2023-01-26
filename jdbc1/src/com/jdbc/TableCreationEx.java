package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TableCreationEx {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sudha@7878");
		Statement st = con.createStatement();

		int rowcount=st.executeUpdate("create table customer(cid integer(5) primary key,cname varchar(20),caddr varchar(15));");
		System.out.println(rowcount);
	}
}
