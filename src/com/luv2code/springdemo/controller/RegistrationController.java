package com.luv2code.springdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.entity.Authority;
import com.luv2code.springdemo.entity.CrmUser;
import com.luv2code.springdemo.entity.User;
import com.luv2code.springdemo.service.AuthorityService;
import com.luv2code.springdemo.service.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	@Autowired
	private UserService userService;
	//@Autowired
	//private AuthorityService authorityService;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	 @InitBinder
		public void initBinder(WebDataBinder dataBinder) {
			
			StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
			
			dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		}	 
	@GetMapping("/Registration-form")
	public String registerForm(Model model){
		System.out.println("the register Controller"); 
		
		model.addAttribute("users", new CrmUser());
		return "register-form";
	}
	@PostMapping("/RegistrationProcessing")
	public String registrationProcss(@Valid @ModelAttribute("users") CrmUser user,Model model
			,BindingResult theBindingResult){

		 if (theBindingResult.hasErrors()){
				System.out.println("the register Controller processing has errors"); 

			 return "register-form";
	        }
			if(user.getUserName()==null||user.getPassword()==null){
				model.addAttribute("users", new CrmUser());
				model.addAttribute("registerError","the UserName or password is null");
				return "register-form";
			}

		if(userService.findUserByName(user.getUserName())){
			model.addAttribute("users", new CrmUser());
			model.addAttribute("registerError","the UserName is existed");

			return "register-form";
		}

		user.setPassword("{bcrypt}"+passwordEncoder.encode(user.getPassword()));
		userService.saveUser(user);
		

		
		return "confirmation-register";
	}
	
	

}
