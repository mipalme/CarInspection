
package se.kth.iv1350.inspection.controller;

import se.kth.iv1350.inspection.integration.CashRegister;
import se.kth.iv1350.inspection.integration.DatabaseManager;
import se.kth.iv1350.inspection.integration.Garage;
import se.kth.iv1350.inspection.integration.PaymentAuthorizationSystem;
import se.kth.iv1350.inspection.integration.Printer;
import se.kth.iv1350.inspection.model.Receipt;
import se.kth.iv1350.inspection.model.Vehicle;
import se.kth.iv1350.inspection.model.CreditCard;
import se.kth.iv1350.inspection.data.InvalidVehicleException;


/**
 * Controller class which initiates all systems, and also calls all methods from other classes.
 * 
 */
public class Controller {
	CashRegister cashRegister = new CashRegister();
	Garage garage = new Garage();
	Printer printer = new Printer();
	DatabaseManager databaseManager = new DatabaseManager();
	PaymentAuthorizationSystem paymentAuthorizationSystem = new PaymentAuthorizationSystem();
	
	/**
         * Opens the garage door and updates the display if a new customer is about to enter the shop.
         * @param number Number of the customer that should be displayed.
         */
	public void newInspection(int number){
		garage.updateDisplay(number);
		garage.openDoor();
		garage.closeDoor();
	}
	/**
         * Creates and prints a new receipt if the customer wants to pay with cash,
         * (also calculates change).
         * @param cost Cost of the inspection.
         * @param amountPayed Amount payed by the customer.
         * @return Returns the change that the customer should receive.
         */
	public double registerCashPayment(double cost, double amountPayed){
		Receipt receipt = new Receipt(cost);
		printer.printReceipt(receipt);
		return cashRegister.calculateChange(cost,amountPayed);			
	}
        /**
         * Verifies the vehicle and finds out the cost of the current inspection, also creates a new instance
         * of the vehicle.
         * @param registrationNumber The registration number of the vehicle that is under inspection.
         * @return Returns the cost of the current inspection.
         * @throws InvalidVehicleException if no vehicle with given registration number is found.
         */
	public double verifyVehicle(String registrationNumber) throws InvalidVehicleException{
		Vehicle vehicle = new Vehicle(registrationNumber);
		return databaseManager.findInspection(vehicle);
	}
        /**
         * Creates a new credit card instance, creates a receipt with the cost of the inspection, prints the receipt,
         * and also verifies the payment.
         * @param pin
         * @param number
         * @param holder
         * @param expireDate
         * @param CVC
         * @param cost 
         * @return If the payment was approved.
         */
	public boolean registerCardPayment(int pin, String number, String holder, int expireDate, int CVC, Double cost){
		CreditCard creditCard = new CreditCard(pin, number, holder, expireDate, CVC);
		Receipt receipt = new Receipt(cost);
		printer.printReceipt(receipt);
                return paymentAuthorizationSystem.requestPayment(creditCard, cost);
	}
        /**
         * Finds the list of inspections associated with the current vehicle.
         * @param registrationNumber The registration number of the vehicle in question.
         * @return The list of inspections.
         */
        public String findInspectionChecklist(String registrationNumber){
            Vehicle vehicle = new Vehicle(registrationNumber);
            return databaseManager.getInspectionChecklist(vehicle);
        }
        /**
         * Finds the next inspection to be made for the current vehicle and stores the result (pass or fail).
         * @param registrationNumber Registration number of the vehicle that is under inspection
         * @return Returns the current inspection if there are any left.
         */
	public String fetchNextInspectionAndStoreResults(String registrationNumber){
		Vehicle vehicle = new Vehicle(registrationNumber);
		for(int i = 0; i <3; i++){
			mapCurrentResult(databaseManager.findInspectionChecklist(vehicle));
		}
		return "No inspections left";
	}
        /**
         * Stores away the current result.
         * @param currentCompletedInspection a String containing the completed inspection that was previously made.
         */
	public void mapCurrentResult(String currentCompletedInspection){
		databaseManager.storeCurrentResult(currentCompletedInspection);	
	}
        /**
         * Prints the result of the total inspection.
         * @param registrationNumber The registration number of the vehicle that is under inspection
         */
	public void printCurrentResult(String registrationNumber){
		Vehicle vehicle = new Vehicle(registrationNumber);
		String finalResults = databaseManager.findFinalResult(vehicle);
		printer.printResult(finalResults, registrationNumber);	
	}
}
