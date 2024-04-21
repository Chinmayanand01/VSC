package com.usecase.virtualcardsys.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class VirtualCard {
	@Id
	@Column(length=16,unique=true)
	private String cardNumber;
	
	@Column
	private String expiryDate;
	@Column(length=4,unique=true)
	private String cvv;
	private int amount;
	
	public VirtualCard() {
		this.cardNumber = generateCardNumber();
		this.expiryDate = generateExpiryDate();
		this.cvv = generateCVV();
	}
	
	private String generateCardNumber() {
		StringBuilder cardNumberBuilder = new StringBuilder();
		for(int i=0;i<16;i++) {
			cardNumberBuilder.append((int)(Math.random()*10));
		}
		return cardNumberBuilder.toString();
	}
	
	private String generateExpiryDate() {
		SimpleDateFormat sdf= new SimpleDateFormat("MM/yyyy");
		Calendar calendar =Calendar.getInstance();
		calendar.add(Calendar.YEAR, 5);
		return sdf.format(calendar.getTime());
	}
	
	private String generateCVV() {
		StringBuilder cvvBuilder = new StringBuilder();
		for(int i=0;i<4;i++) {
			cvvBuilder.append((int)(Math.random()*10)); 
		}
		return cvvBuilder.toString();
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
