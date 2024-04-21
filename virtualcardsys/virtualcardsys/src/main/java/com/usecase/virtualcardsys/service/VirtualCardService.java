package com.usecase.virtualcardsys.service;

import com.usecase.virtualcardsys.model.VirtualCard;

public interface VirtualCardService {
	public VirtualCard createVirtualCard(int amount);
	public boolean transferMoney(String senderCardNumber,String recipientCardNumber, int amount);
	
}
