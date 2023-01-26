package com.jdbc.realtime;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public String add(Customer customer) {
		CustomerDao customerDao = CustomerDaoFactory.getCustomerDao();
		String status = customerDao.add(customer);
		return status;
	}

	@Override
	public Customer search(int cid) {
		CustomerDao customerDao = CustomerDaoFactory.getCustomerDao();
		Customer customer = customerDao.search(cid);
		return customer;
	}

	@Override
	public String update(Customer customer) {
		CustomerDao customerDao = CustomerDaoFactory.getCustomerDao();
		String status = customerDao.update(customer);
		return status;
	}

	@Override
	public String delete(int cid) {
		CustomerDao customerDao = CustomerDaoFactory.getCustomerDao();
		String status = customerDao.delete(cid);
		return status;
	}

}
