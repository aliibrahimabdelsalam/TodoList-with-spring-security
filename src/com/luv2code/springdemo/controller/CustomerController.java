package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
public class CustomerController {

	
	@Autowired
	public CustomerService customerService;
	@GetMapping("/")
	public String listCustomer(Model model){

		List<Customer> theCustomer=customerService.getCustomerList();
		model.addAttribute("customers",theCustomer);
		return "list-customers"; 
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model){
		Customer customer=new Customer();
		 model.addAttribute("customer",customer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
		customerService.saveCustomer(theCustomer);
		//		return "redirect:/customer/list";

		return "redirect:/";
	}
	@GetMapping("/search")
	public String searchCustomer(Model model,@RequestParam("search")String name){
		List<Customer> customers=customerService.searchCustomer(name);
		System.out.print("the search :: "+name);
		for(Customer customer: customers)
		{
			System.out.println("the customer :: "+customer.getFirstName()+"/n theSearchName.trim().length():: "+name.trim().length()  );
		}
		model.addAttribute("customers",customers);

		//		return "redirect:/customer/list";

		return "list-customers";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id,Model model){
		Customer theCustomer=customerService.getCustomer(id);
		model.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	@GetMapping("/showFormForDelete")
	public String showFormForDelete(@RequestParam("customerId") int id ){
		customerService.deleteCustomer(id);
		
		return "redirect:/";
	}
	@GetMapping("/test")
	public String showSecurity(){
		return "home";
	}
	@GetMapping("/leader")
	public String showLeader(){
		System.out.println("here security");		
		return "leader";
	}
	@GetMapping("/system")
	public String showSystem(){
		System.out.println("here security");		
		return "system";
	}
	
}
