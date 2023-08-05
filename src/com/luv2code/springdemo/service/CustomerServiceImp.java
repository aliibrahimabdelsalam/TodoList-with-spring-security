package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDao;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	public CustomerDao customerDao;
	@Override
	@Transactional
	public List<Customer> getCustomerList() {
		
		return customerDao.getCustomerList();
	}
	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDao.saveCustomer(theCustomer);
		
	}
	@Override
	@Transactional
	public Customer getCustomer(int id) {
		
		return customerDao.getCustomer(id);
	}
	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
	}
	@Override
	@Transactional
	public List<Customer> searchCustomer(String name) {
		// TODO Auto-generated method stub
		return customerDao.searchCustomer(name);
	}

}
