package com.jdbc.realtime;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CustomerMain {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.println("==============================");
				System.out.println("1. ADD");
				System.out.println("2. SEARCH");
				System.out.println("3. UPDATE");
				System.out.println("4. DELETE");
				System.out.println("5. EXIT");
				System.out.println("Your Option[1,2,3,4,5] : ");
				int option = Integer.parseInt(br.readLine());
				int cid = 0;
				String cname = "";
				String caddr = "";
				CustomerService customerService = CustomerServiceFactory.getCustomerService();
				Customer customer = null;
				switch (option) {
				case 1:
					System.out.println("================================");
					System.out.println("Customer Id :");
					cid = Integer.parseInt(br.readLine());
					System.out.println("Customer Name :");
					cname = br.readLine();
					System.out.println("Customer Address :");
					caddr = br.readLine();
					customer = new Customer();
					customer.setCid(cid);
					customer.setCname(cname);
					customer.setCaddr(caddr);
					String status = customerService.add(customer);
					System.out.println("Status :" + status);
					break;
				case 2:
					System.out.println("Customer Id : ");
					cid = Integer.parseInt(br.readLine());
					customer = customerService.search(cid);//101,102,103
					if (customer == null) {
						System.out.println("Customer Not Existed");
					} else {
						System.out.println("Customer Details");
						System.out.println("---------------------");
						System.out.println("Customer Id :" + customer.getCid());
						System.out.println("Customer Name :" + customer.getCname());
						System.out.println("Customer Address :" + customer.getCaddr());
					}
					break;
				case 3:
					System.out.println("Customer Id :");
					cid = Integer.parseInt(br.readLine());
					customer = customerService.search(cid);
					if (customer == null) {
						System.out.println("Status : Customer Not Existed");
					} else {
						System.out.println("Customer Name : " + customer.getCname() + "] : ");
						String cname_new = br.readLine();
						if (cname_new == null || cname_new.equals("")) {
							cname_new = customer.getCname();
						}
						System.out.println("Customer Address [Old Address : " + customer.getCaddr() + "] : ");
						String caddr_new = br.readLine();
						if (caddr_new == null || caddr_new.equals("")) {
							caddr_new = customer.getCaddr();
						}

						Customer customer_new = new Customer();
						customer_new.setCid(cid);
						customer_new.setCname(cname_new);
						customer_new.setCaddr(caddr_new);
						status = customerService.update(customer_new);
						System.out.println("Status :" + status);
					}
					break;
				case 4:
					System.out.println("Customer Id :");
					cid = Integer.parseInt(br.readLine());
					customer = customerService.search(cid);
					if (customer == null) {
						System.out.println("Status : Customer Not Existed");
					} else {
						status = customerService.delete(cid);
						System.out.println("Status : " + status);
					}
					break;
				case 5:
					System.out.println("***********Thank you for using Customer Application********");
					System.exit(0);
					break;
				default:
					System.out.println("Provide number from 1,2,3,4,5");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
