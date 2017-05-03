
package se.kth.iv1350.inspection.integration;

public class CashRegister {
	
	private double cashInRegister = 500;
        
        //The cash register has 500 dollars in it to begin with.
	
	public void updateCash(double cost){
		cashInRegister = cost + cashInRegister;
		System.out.println("The cashregister now contains "+cashInRegister+" $");
	}
	public double calculateChange(double cost, double amountPayed){
		updateCash(cost);
		double change = amountPayed - cost;
		System.out.println("Your change is: " +change+" $");
		return change;
	}
	
	
}