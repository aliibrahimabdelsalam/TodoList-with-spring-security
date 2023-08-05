package com.luv2code.springdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Authority;

@Repository
public class AuthorityDaoImp implements AuthorityDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void saveAuthority(Authority authority) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(authority);

	}

}
