
package se.kth.iv1350.inspection.controller;

import se.kth.iv1350.inspection.integration.CashRegister;
import se.kth.iv1350.inspection.integration.DatabaseManager;
import se.kth.iv1350.inspection.integration.Garage;
import se.kth.iv1350.inspection.integration.PaymentAuthorizationSystem;
import se.kth.iv1350.inspection.integration.Printer;
import se.kth.iv1350.inspection.model.Receipt;
import se.kth.iv1350.inspection.model.Vehicle;
import se.kth.iv1350.inspection.model.CreditCard;


//Initiates objects that are systems, which the controller has the responsibility 
//of initiating.
public class Controller {

	CashRegister cashRegister = new CashRegister();
	Garage garage = new Garage();
	Printer printer = new Printer();
	DatabaseManager databaseManager = new DatabaseManager();
	PaymentAuthorizationSystem paymentAuthorizationSystem = new PaymentAuthorizationSystem();
	
	/**
         * 
         * @param number of the customer that should be displayed
         */
	public void newInspection(int number){
		garage.updateDisplay(number);
		garage.openDoor();
		garage.closeDoor();
	}
	/**
         * 
         * @param cost of the inspection
         * @param amountPayed
         * @return 
         */
	public double registerCashPayment(double cost, double amountPayed){
		Receipt receipt = new Receipt(cost);
		printer.printReceipt(receipt);
		return cashRegister.calculateChange(cost,amountPayed);
				
	}
        /**
         * 
         * @param registrationNumber of the vehicle that is under inspection
         * @return 
         */
	public double verifyVehicle(String registrationNumber){
		Vehicle vehicle = new Vehicle(registrationNumber);
		return databaseManager.findInspection(vehicle);
	}
        /**
         * 
         * @param pin
         * @param number
         * @param holder
         * @param expireDate
         * @param CVC
         * @param cost 
         */
	public void registerCardPayment(int pin, String number, String holder, int expireDate, int CVC, Double cost){
		CreditCard creditCard = new CreditCard(pin, number, holder, expireDate, CVC);
		Receipt receipt = new Receipt(cost);
		paymentAuthorizationSystem.requestPayment(creditCard, cost);
		printer.printReceipt(receipt);
	}
        /**
         * 
         * @param registrationNumber of the vehicle that is under inspection
         * @return 
         */
	public String fetchNextInspectionAndStoreResults(String registrationNumber){
		Vehicle vehicle = new Vehicle(registrationNumber);
		for(int i = 0; i <3; i++){
			mapCurrentResult(databaseManager.findInspectionChecklist(vehicle));
		}
		return "No inspections left";
	}
        /**
         * 
         * @param currentCompletedInspection a String containing the completed inspection that was previously made
         */
	public void mapCurrentResult(String currentCompletedInspection){
		databaseManager.storeCurrentResult(currentCompletedInspection);
		
	}
        /**
         * 
         * @param registrationNumber of the vehicle that is under inspection
         */
	public void printCurrentResult(String registrationNumber){
		Vehicle vehicle = new Vehicle(registrationNumber);
		String finnalResults = databaseManager.findFinalResult(vehicle);
		printer.printResult(finnalResults, registrationNumber);	
	}
}
