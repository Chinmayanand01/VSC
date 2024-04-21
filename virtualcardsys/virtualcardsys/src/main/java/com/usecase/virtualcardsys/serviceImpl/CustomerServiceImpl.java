package com.usecase.virtualcardsys.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.virtualcardsys.DAO.CustomerRepository;
import com.usecase.virtualcardsys.model.CustomerRegistration;
import com.usecase.virtualcardsys.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public String registerCustomer(CustomerRegistration customer) {
		customerRepository.save(customer);
		return "Customer Registered Successfully";
	}
	
	@Override
	public CustomerRegistration login(String username,String password) {
		return customerRepository.findByUsernameAndPassword(username,password);
	}

}
