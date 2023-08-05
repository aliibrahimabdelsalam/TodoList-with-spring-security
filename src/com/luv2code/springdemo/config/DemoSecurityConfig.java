	package com.luv2code.springdemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		/*
		UserBuilder users=User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(users.username("ali").password("test123").roles("EMPLOYEE"))
		.withUser(users.username("ibrahim").password("test123").roles("EMPLOYEE","MANAGER"))
		.withUser(users.username("abdelsalam").password("test123").roles("EMPLOYEE","ADMIN"));
	*/
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	//// custom our Login 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/leader/**").hasRole("MANAGER")
		.antMatchers("/system/**").hasRole("ADMIN").  //any request servlet should be authenticate
		and().formLogin().loginPage("/showMyLoginPage") //login Page 
		.loginProcessingUrl("/authenticateTheUser"). //check the data is right or no we don't make anythink
		permitAll().
		and().logout().permitAll()
		.and()
		.exceptionHandling()
		.accessDeniedPage("/access-denied"); //anyone one see login Page
		
	}

	
	
}
