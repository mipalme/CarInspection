package se.kth.iv1350.inspection.view;

import se.kth.iv1350.inspection.controller.Controller;
import se.kth.iv1350.inspection.model.InvalidVehicleException;
import se.kth.iv1350.inspection.util.LogHandler;
import java.io.IOException;

/**
 * This class represents the outside world initiating the steps of the program
 * (such as a customer paying for example).
 * 
 */
public class View {
	
	private final Controller controller;
        private final String currentVehicleToInspect = "ELF523";
        LogHandler logger;
        InspectionStatsView inspectionstatsview;
       
	/**
	 * Initiates an instance of the object controller, also checks for IOException,
         * and sets the logger to null if an exception occurred.
	 * @param controller. The object controller.
         * 
	 */
	public View(Controller controller){
		this.controller = controller; 
                try{
                    logger = new LogHandler();
                }
                catch (IOException e){
                    logger = null;
                }    
	}
        /**
         * Tests various system operations to make sure the program is functioning
         * properly without logical errors.
         */
	public void testSystemOperations (){
		//Different SystemOperations.
                try{
                    controller.newInspection(1);//number to update display with.
                    controller.registerCashPayment(1000, 1200); //what the inspection costs, what the constumer payed.
                    System.out.println("Inspections found! The cost of the inspections are: "+controller.verifyVehicle(currentVehicleToInspect)+"$"); //checks with database if this vehicle exists.
                    controller.registerCardPayment(3141, "592 653 589", "Michael", 7932, 384, (double) 6267); //creditcard information.
                    System.out.println("Your inspections are: "+controller.findInspectionChecklist(currentVehicleToInspect));
                    controller.fetchNextInspectionAndStoreResults(currentVehicleToInspect); 
                    controller.printCurrentResult(currentVehicleToInspect);	
                }
                catch(InvalidVehicleException invalidVehicle){
                    System.out.println(invalidVehicle.getMessage()); 
                    logger.logException(invalidVehicle);
                }
	}
}