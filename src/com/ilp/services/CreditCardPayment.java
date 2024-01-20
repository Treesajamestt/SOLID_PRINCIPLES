
package com.ilp.services;

import com.ilp.entity.PaymentDetails;

public class CreditCardPayment extends BasePayment {

    private static final double TAX_RATE = 0.05; // 5% tax rate

    @Override
    public boolean processPayment(String paymentToken, double amount) {
        double totalAmount = calculateTotalAmount(amount);
        System.out.println("Card Payment");
        System.out.println("Original Amount: " + amount);
        System.out.println("Total Amount with 5% Tax: " + totalAmount);
        return true; // Return success or failure
    }

    @Override
    public boolean processPayment(PaymentDetails paymentDetails) {
        double totalAmount = calculateTotalAmount(paymentDetails.getAmount());
        System.out.println("Card Payment");
        System.out.println("Original Amount: " + paymentDetails.getAmount());
        System.out.println("Total Amount with 5% Tax: " + totalAmount);
        return true;
    }

    public double calculateTotalAmount(double originalAmount) {
        return originalAmount + (originalAmount * TAX_RATE);
    }

}
