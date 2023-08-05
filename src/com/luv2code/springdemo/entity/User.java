package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;

	@Column(name="enabled")
	private int enabled;
	public User(){
		this.userName = "s";
		this.password = "1";
		this.enabled = 0;
	}

	public User(String userName, String password, int enabled) {
		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password
				+ ", enabled=" + enabled + "]";
	}
	
	

}
