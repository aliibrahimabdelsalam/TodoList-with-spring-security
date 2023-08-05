package com.luv2code.springdemo.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CrmUser {

	@NotNull(message="is required username")
	@Size(min=5,message="is size at least is 5")
	private String userName;
	@NotNull(message="is required password")
	@Size(min=5,message="is size at least is 5")
	private String password;
	private int enabled;
	
	public CrmUser(){
		this.userName = "s";
		this.password = "1";
		this.enabled = 0;
	}

	public CrmUser(String userName, String password, int enabled) {
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
		return "CrmUser [userName=" + userName + ", password=" + password
				+ ", enabled=" + enabled + "]";
	}
	
}
