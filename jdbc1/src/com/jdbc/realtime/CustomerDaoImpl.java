package com.jdbc.realtime;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public String add(Customer customer) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from customer where CID = " + customer.getCid() + "");
			boolean b = rs.next();
			if (b == true) {
				status = "Customer Existed Already";
			} else {
				int rowCount = st.executeUpdate("insert into customer values(" + customer.getCid() + ",'"
						+ customer.getCname() + "','" + customer.getCaddr() + "')");
				if (rowCount == 1) {
					status = "Customer Insertion Success";
				} else {
					status = "Customer Insertion Failure";
				}
			}
		} catch (Exception e) {
			status = "Customer Insertion Failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Customer search(int cid) {
		Customer customer = null;
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from customer where CID = " + cid + "");
			boolean b = rs.next();
			if (b == true) {
				customer = new Customer();
				customer.setCid(rs.getInt("cid"));
				customer.setCname(rs.getString("cname"));
				customer.setCaddr(rs.getString("caddr"));
			} else {
				customer = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public String update(Customer customer) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			int rowCount = st.executeUpdate("update customer set CNAME = '" + customer.getCname() + "',CADDR='"
					+ customer.getCaddr() + "' where CID=" + customer.getCid() + "");

			if (rowCount == 1) {
				status = "Customer Updation Success";
			} else {
				status = "Customer Insertion Success";
			}
		} catch (Exception e) {
			status = "Customer Insertion Failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String delete(int cid) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			int rowCount = st.executeUpdate("delete from customer where CID=" + cid + "");

			if (rowCount == 1) {
				status = "Customer Updation Success";
			} else {
				status = "Customer Insertion Success";
			}
		} catch (Exception e) {
			status = "Customer Insertion Failure";
			e.printStackTrace();
		}
		return status;
	}

}
