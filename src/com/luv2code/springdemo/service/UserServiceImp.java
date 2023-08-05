package com.luv2code.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.AuthorityDao;
import com.luv2code.springdemo.dao.UserDao;
import com.luv2code.springdemo.entity.Authority;
import com.luv2code.springdemo.entity.CrmUser;
import com.luv2code.springdemo.entity.User;


@Service
public class UserServiceImp implements UserService {

	@Autowired 
	private AuthorityDao authorityDao;
	@Autowired
	private UserDao userDao;
	@Override
	@Transactional
	public void saveUser(CrmUser theUser) {
		Authority authority=new Authority();
		User user=new User();
		user.setUserName(theUser.getUserName());
		user.setPassword(theUser.getPassword());
		user.setEnabled(theUser.getEnabled());
		userDao.saveUser(user);
		authority.setUserName(theUser.getUserName());
		authority.setAuthority("ROLE_EMPLOYEE");
		authorityDao.saveAuthority(authority);
		
	}
	@Override
	@Transactional
	public boolean findUserByName(String name) {

		
		return userDao.findUserByName(name); 
	}

}
