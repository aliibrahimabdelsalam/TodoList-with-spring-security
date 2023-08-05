package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerDao {

	public List<Customer> getCustomerList();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);
	public List<Customer> searchCustomer(String name);


	public void deleteCustomer(int id);

}
