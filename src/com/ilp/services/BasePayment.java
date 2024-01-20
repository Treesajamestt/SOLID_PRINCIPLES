package com.ilp.services;

import com.ilp.interfaces.PaymentProcessor;

public abstract class BasePayment implements  PaymentProcessor{
		public boolean processPayment(String paymentToken, double amount) {
	        System.out.println("Basic payment logic for all payment method");
			return true;
	    }
	}

