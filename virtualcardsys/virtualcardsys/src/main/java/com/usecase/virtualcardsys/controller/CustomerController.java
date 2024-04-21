package com.usecase.virtualcardsys.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.usecase.virtualcardsys.model.CustomerRegistration;
import com.usecase.virtualcardsys.model.LoginDetails;
import com.usecase.virtualcardsys.model.TransferMoney;
import com.usecase.virtualcardsys.model.VirtualCard;
import com.usecase.virtualcardsys.serviceImpl.CustomerServiceImpl;
import com.usecase.virtualcardsys.serviceImpl.VirtualCardServiceImpl;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	@Autowired
	private VirtualCardServiceImpl virtualCardServiceImpl;
	
	
	@PostMapping("/vcs/register")
	public ResponseEntity<String> newRegister(@RequestBody CustomerRegistration customer){
		String msg=customerServiceImpl.registerCustomer(customer);
		return ResponseEntity.ok(msg);
	}
	
	@PostMapping("/vcs/login")
	public ResponseEntity<CustomerRegistration> loginCustomer(@RequestBody LoginDetails credentials){
		String username= credentials.getUsername();
		String password = credentials.getPassword();
		CustomerRegistration user = customerServiceImpl.login(username, password);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@PostMapping("/vcs/createvc")
	public ResponseEntity<VirtualCard> createVC(@RequestBody ObjectNode objectNode){
		int amount = objectNode.get("amount").asInt();
		VirtualCard vc= virtualCardServiceImpl.createVirtualCard(amount);
		return new ResponseEntity<>(vc,HttpStatus.OK);
	}
	
	@PostMapping("/vcs/transfer")
	public ResponseEntity<String> transferAmount(@RequestBody TransferMoney transferReq){
		boolean success= virtualCardServiceImpl.transferMoney(transferReq.getSenderCardNumber(), transferReq.getRecipientCardNumber(), transferReq.getAmount());
		if(success) {
			return new ResponseEntity<>("Transfer successful",HttpStatus.OK);
		}
		else
			return new ResponseEntity<>("Transfer Unsuccessful",HttpStatus.BAD_REQUEST);
	}

}
