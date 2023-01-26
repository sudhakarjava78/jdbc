package com.jdbc.realtime;

public interface CustomerService {

	public String add(Customer customer);

	public Customer search(int cid);

	public String update(Customer customer);

	public String delete(int cid);
}
