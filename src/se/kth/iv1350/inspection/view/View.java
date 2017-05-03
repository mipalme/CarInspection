package se.kth.iv1350.inspection.view;

import se.kth.iv1350.inspection.controller.Controller;


public class View {
	
	private final Controller controller;
	
	/**
	 * 
	 * @param controller. The object controller. 
	 */
	public View(Controller controller){
		this.controller = controller;
	}
	
	/**
	 * This Vehicles are in queue outside the garage, only one can be inspected at the same time, you choose who!
	 */
	 private static String currentVehicleToInspect = "ELF523"; 
                                                                                                    //"ELF523";  Registered vehicle
	 											    //"LKF245"	 Registered vehicle
	 											    //"LDK424"	 Registered vehicle
	 											    //"NPC999"   Vehicle not in database
	
	public void testSystemOperations(){
		//Different SystemOperations.
		controller.newInspection(1);//number update display with
		controller.registerCashPayment(1000, 1200); //what the inspection cost, what the constumer payed
		controller.verifyVehicle(currentVehicleToInspect); //checks with database if this vehicle exists
		controller.registerCardPayment(3141, "592 653 589", "Michael", 7932, 384, (double) 6267); //creditcard information
		controller.fetchNextInspectionAndStoreResults(currentVehicleToInspect); 
		controller.printCurrentResult(currentVehicleToInspect);
		
	}
}