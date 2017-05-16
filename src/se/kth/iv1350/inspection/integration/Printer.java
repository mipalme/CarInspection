
package se.kth.iv1350.inspection.integration;

import se.kth.iv1350.inspection.model.Receipt;

/**
 * This class handles the printer that prints both receipts and inspection results.
 * 
 */
public class Printer {	
	/**
	 * Prints a given receipt.
	 * @param receipt receipt that is to be printer when the method is called.
	 */
	public void printReceipt(Receipt receipt){
		System.out.println("A receipt has been printed");
	}
	/**
	 * Prints the final results of the inspection.
	 * @param finalInspectionResult. The inspectionResults that will be printed when the method is called.
	 * @param registrationNumber. The registration number of the inspected vehicle.
	 */
	public void printResult(String finalInspectionResult, String registrationNumber){
		System.out.println("All results for the inspections :"+finalInspectionResult+" have been printed for Vehicle: " +registrationNumber+".");
	}
}
