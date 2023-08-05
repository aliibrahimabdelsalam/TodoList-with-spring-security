package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDaoImp implements CustomerDao {

	@Autowired
	public SessionFactory sessionFactory;
	@Override
	public List<Customer> getCustomerList() {
		
		Session currentSession=sessionFactory.getCurrentSession();

		Query<Customer> theQuery =currentSession.createQuery("from Customer",Customer.class);

		List<Customer> customers=theQuery.getResultList();
		
		return customers;
	}
	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession=sessionFactory.getCurrentSession();
		//currentSession.save(theCustomer);
		
		// if the primarykey id is emply do save
		//else update
		currentSession.saveOrUpdate(theCustomer);
		
	}
	@Override
	public Customer getCustomer(int id) {
		Session currentSession=sessionFactory.getCurrentSession();
		Customer theCustomer=currentSession.get(Customer.class, id);
		return theCustomer;
	}
	@Override
	public void deleteCustomer(int id) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query theQuery=currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", id);
		theQuery.executeUpdate();
		
	}
	@Override
	public List<Customer> searchCustomer(String name) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query theQuery=null;
		if(name!=null && name.trim().length()>0){
		 theQuery =currentSession.createQuery("from Customer where first_name like'%"+name+"%'"
				                                            + "or last_name like '%"+name+"%'",Customer.class);
		}
		else{
            theQuery =currentSession.createQuery("from Customer", Customer.class);            

		}
		List<Customer> customers=theQuery.getResultList();
		
		return customers;
	}

}
