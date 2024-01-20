package com.ilp.utility;

import java.util.Scanner;

import com.ilp.entity.PaymentDetails;
import com.ilp.interfaces.PaymentProcessor;
import com.ilp.services.APIPayment;
import com.ilp.services.CreditCardPayment;
import com.ilp.services.IMdbProMembership;

public class Main {
    public static void main(String[] args) {
        // Create payment details
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setPaymentToken("xyz123");
        paymentDetails.setAmount(100.0);
        // Display menu for payment processors
        System.out.println("Choose a payment processor:");
        System.out.println("1. API Payment");
        System.out.println("2. Credit Card Payment");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        // Create payment processor based on user choice
        PaymentProcessor paymentProcessor;
        switch (choice) {
            case 1:
                paymentProcessor = new APIPayment();
                break;
            case 2:
                paymentProcessor = new CreditCardPayment();
                break;
            default:
                System.out.println("Invalid choice. Exiting program.");
                return;
        }

        // Process payment using the selected processor
        processPayment(paymentProcessor, paymentDetails);

        // Create IMDbProMembershipService with the selected payment processor
        IMdbProMembership proMembershipService = new IMdbProMembership(paymentProcessor);

        // Handle payment using IMDbProMembershipService
        proMembershipService.handlePayment(paymentDetails);


    }

    private static void processPayment(PaymentProcessor processor, PaymentDetails paymentDetails) {
        boolean result = processor.processPayment(paymentDetails);
        double displayedAmount = paymentDetails.getAmount(); // Default displayed amount

        if (processor instanceof CreditCardPayment) {
            // If the processor is CreditCardPayment, adjust displayed amount with tax
            displayedAmount = ((CreditCardPayment) processor).calculateTotalAmount(displayedAmount);
        }
        else{
            // If the processor is APIPayment, adjust displayed amount with tax
            displayedAmount = ((APIPayment) processor).calculateTotalAmount(displayedAmount);
        }
        System.out.println("Payment processed successfully: " + result);
        System.out.println("Displayed Amount: " + displayedAmount);
    
        System.out.println("Payment processed successfully: " + result);
    }
}
