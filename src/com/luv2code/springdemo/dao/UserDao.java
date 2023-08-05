package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.User;

public interface UserDao {

	public void saveUser(User theUser);
	public boolean findUserByName(String name);

}
