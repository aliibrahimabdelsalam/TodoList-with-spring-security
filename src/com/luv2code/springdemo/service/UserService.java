package com.luv2code.springdemo.service;

import com.luv2code.springdemo.entity.CrmUser;

public interface UserService {

	public void saveUser(CrmUser theUser);
	public boolean findUserByName(String name);

}
