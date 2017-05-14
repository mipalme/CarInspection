package se.kth.iv1350.inspection.view;

import se.kth.iv1350.inspection.controller.Controller;

/**
 * This class represents the outside world initiating the steps of the program
 * (such as a customer paying for example).
 * 
 */
public class View {
	
	private final Controller controller;
        private final String currentVehicleToInspect = "ELF523";
	
	/**
	 * Initiates an instance of the object controller.
	 * @param controller. The object controller. 
	 */
	public View(Controller controller){
		this.controller = controller;
	}
        /**
         * Tests various system operations to make sure the program is functioning
         * properly without logical errors.
         */
	public void testSystemOperations(){
		//Different SystemOperations.
		controller.newInspection(1);//number to update display with.
		controller.registerCashPayment(1000, 1200); //what the inspection costs, what the constumer payed.
		controller.verifyVehicle(currentVehicleToInspect); //checks with database if this vehicle exists.
		controller.registerCardPayment(3141, "592 653 589", "Michael", 7932, 384, (double) 6267); //creditcard information.
		controller.fetchNextInspectionAndStoreResults(currentVehicleToInspect); 
		controller.printCurrentResult(currentVehicleToInspect);	
	}
}