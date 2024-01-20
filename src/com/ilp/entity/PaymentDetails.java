package com.ilp.entity;

//Payment details class representing the information about a payment

public class PaymentDetails {
	private String paymentToken;
    private double amount;
    
    
	public PaymentDetails() {
		super();
		this.paymentToken = paymentToken;
		this.amount = amount;
	}
	public String getPaymentToken() {
		return paymentToken;
	}
	public void setPaymentToken(String paymentToken) {
		this.paymentToken = paymentToken;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
