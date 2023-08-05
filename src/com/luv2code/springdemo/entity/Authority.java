package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="authorities")
public class Authority {

	@Id
	@Column(name="username")
	private String userName;
	
	@Column(name="authority")
	private String authority;

	public Authority(){
		
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Authority [userName=" + userName + ", authority=" + authority
				+ "]";
	}
	
}
