package com.ilp.interfaces;

import com.ilp.entity.PaymentDetails;

public interface PaymentProcessor {
		

		boolean processPayment(PaymentDetails paymentDetails);
	}


