
package se.kth.iv1350.inspection.integration;

import se.kth.iv1350.inspection.model.CreditCard;
/**
 * This class handles the payment authorization system which checks the customers credit card.
 * 
 */
public class PaymentAuthorizationSystem {
        /**
         * Requests a payment from the customers bank account using the customers credit card.
         * @param creditCard The customers credit card.
         * @param cost The amount to be deducted from the customers account.
         * @return If the payment was successful (dummy method, always returns true.)
         */
	public boolean requestPayment(CreditCard creditCard, Double cost){
		System.out.println("PaymentAuthorizationSystem: payment approved");
		return true;	
	}
}
