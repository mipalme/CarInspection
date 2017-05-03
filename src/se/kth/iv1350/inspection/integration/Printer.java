
package se.kth.iv1350.inspection.integration;

import se.kth.iv1350.inspection.model.Receipt;


public class Printer {

		
	/**
	 * 
	 * @param receipt object that is to be printer when method is called.
	 */
	
	public void printReceipt(Receipt receipt){
		//Prints the receipt
		System.out.println("A receipt has been printed");
	}
	
	/**
	 * 
	 * @param finalInspectionResult. The final inspectionResults that will be printed when method is called
	 * @param registrationNumber. The registration number on the inspected vehicle
	 */
	public void printResult(String finalInspectionResult, String registrationNumber){
		//prints the inspectionresults
		System.out.println("All results for the inspections :"+finalInspectionResult+" has been printed for Vehicle: " +registrationNumber+".");
	}
}
