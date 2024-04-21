package com.usecase.virtualcardsys.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.virtualcardsys.DAO.VirtualCardRepository;
import com.usecase.virtualcardsys.model.VirtualCard;

@Service
public class VirtualCardServiceImpl {
	@Autowired
	private VirtualCardRepository virtualCardRepository;
	
	public VirtualCard createVirtualCard(int amount) {
		VirtualCard virtualCard = new VirtualCard();
		virtualCard.setAmount(amount);
		return virtualCardRepository.save(virtualCard);
	}
	
	public boolean transferMoney(String senderCardNumber,String recipientCardNumber, int amount) {
		VirtualCard senderCard = virtualCardRepository.findByCardNumber(senderCardNumber);
		VirtualCard recipientCard = virtualCardRepository.findByCardNumber(recipientCardNumber);
		
		if(senderCard == null || recipientCard== null || senderCard.getAmount()<amount) {
			return false;
		}
		
		senderCard.setAmount(senderCard.getAmount() - amount);
		recipientCard.setAmount(recipientCard.getAmount()+amount);
		
		virtualCardRepository.save(senderCard);
		virtualCardRepository.save(recipientCard);
		
		return true;
		
	}
}
