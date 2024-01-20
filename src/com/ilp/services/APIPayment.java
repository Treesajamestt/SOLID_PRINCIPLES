package com.ilp.services;

import com.ilp.entity.PaymentDetails;

public class APIPayment  extends BasePayment{
	private static final double DISCOUNT = 50; //
	 public boolean processPayment(String paymentToken, double amount) {
	        System.out.println("API Payment");
	        double totalAmount = calculateTotalAmount(amount);
	        System.out.println("Original Amount: " + amount);
	        System.out.println("Total Amount with Discount: " + totalAmount);
	        return true; // Return success or failure
	        
	    }

	public double calculateTotalAmount(double originalAmount) {
		// TODO Auto-generated method stub
	        return (originalAmount-DISCOUNT);
	    
		
	}

	@Override
	public boolean processPayment(PaymentDetails paymentDetails) {
		// TODO Auto-generated method stub
		double totalAmount = calculateTotalAmount(paymentDetails.getAmount());
        System.out.println("API Payment");
        System.out.println("Original Amount: " + paymentDetails.getAmount());
        System.out.println("Total Amount with Discount: " + totalAmount);
        return true;
	}
}
