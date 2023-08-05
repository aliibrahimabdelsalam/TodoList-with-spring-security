package com.luv2code.springdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.User;

@Repository
public class UserDaoImp implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveUser(User theUser) {
		Session currentSession=sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theUser);

	}

	@Override
	public boolean findUserByName(String name) {

		Session currentSession=sessionFactory.getCurrentSession();
		User user=currentSession.get(User.class, name);
		if(user==null){
			return false;
		}
		return true;
	}

}
