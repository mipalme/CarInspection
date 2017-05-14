
package se.kth.iv1350.inspection.integration;
/**
 * This class handles the cash register which is used if the customer pays with cash.
 * 
 */
public class CashRegister {
	/**
         * The amount of money in the cash register.
         */
	public double cashInRegister = 500;
        /**
         * Adds a value to the current amount of money in the register.
         * @param cost The value to be added.
         */
	public void updateCash(double cost){
		cashInRegister = cost + cashInRegister;
		System.out.println("The cashregister now contains "+cashInRegister+" $");
	}
        /**
         * Calculated how much change the customer should receive.
         * @param cost The cost of the purchase.
         * @param amountPayed The amount of money payed by the customer.
         * @return The change the customer shall receive.
         */
	public double calculateChange(double cost, double amountPayed){
		updateCash(cost);
		double change = amountPayed - cost;
		System.out.println("Your change is: " +change+" $");
		return change;
	}	
}