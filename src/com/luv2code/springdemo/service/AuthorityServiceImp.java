package com.luv2code.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.AuthorityDao;
import com.luv2code.springdemo.entity.Authority;

@Service
public class AuthorityServiceImp implements AuthorityService {

	@Autowired
	private AuthorityDao authorityDao;
	@Override
	@Transactional
	public void saveUser(Authority theAuthority) {
		authorityDao.saveAuthority(theAuthority);

	}

}
