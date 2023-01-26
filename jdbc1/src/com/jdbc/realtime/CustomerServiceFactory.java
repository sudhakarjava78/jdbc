package com.jdbc.realtime;

public class CustomerServiceFactory {

	private static CustomerService customerService;

	static {
		customerService = new CustomerServiceImpl();
	}

	public static CustomerService getCustomerService() {
		return customerService;
	}
}
