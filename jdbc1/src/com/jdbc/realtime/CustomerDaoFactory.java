package com.jdbc.realtime;

public class CustomerDaoFactory {

	private static CustomerDao customerDao;

	static {
		customerDao = new CustomerDaoImpl();
	}

	public static CustomerDao getCustomerDao() {
		return customerDao;
	}
}
