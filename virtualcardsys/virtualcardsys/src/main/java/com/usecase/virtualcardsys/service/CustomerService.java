package com.usecase.virtualcardsys.service;

import com.usecase.virtualcardsys.model.CustomerRegistration;

public interface CustomerService {
	public String registerCustomer(CustomerRegistration customer);
	public CustomerRegistration login(String username,String password);
	
}
