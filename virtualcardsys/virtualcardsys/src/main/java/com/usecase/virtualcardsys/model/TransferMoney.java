package com.usecase.virtualcardsys.model;

public class TransferMoney {
	private String senderCardNumber;
	private String recipientCardNumber;
	private int amount;
	public String getSenderCardNumber() {
		return senderCardNumber;
	}
	public void setSenderCardNumber(String senderCardNumber) {
		this.senderCardNumber = senderCardNumber;
	}
	public String getRecipientCardNumber() {
		return recipientCardNumber;
	}
	public void setRecipientCardNumber(String recipientCardNumber) {
		this.recipientCardNumber = recipientCardNumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
