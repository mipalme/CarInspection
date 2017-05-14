
package se.kth.iv1350.inspection.data;

import java.util.Arrays;
import se.kth.iv1350.inspection.model.Vehicle;
/**
 * This class represents the non-existant database, and is filled with fabricated information about 
 * various example vehicles and inspections.
 * 
 */
public class Database {
	
	private int currentInspectionCounter = 0;
	private int saveCurrentInspectionCounter = 0;
        
	private final double cost = 1000;
	
	private final Vehicle vehicle = new Vehicle("ELF523");
	private final Vehicle vehicle1 = new Vehicle("LKF245");
	private final Vehicle vehicle2 = new Vehicle("LDK424");
        
	
	private final String[] inspectionChecklist = {"check oil","check windows","check lights"};
	private final String[] inspectionChecklist1 = {"check oil","check seats","check wheels"};
	private final String[] inspectionChecklist2 = {"check oil","check engine","check dashboard"};
	private final String[] noCheckListFound = {"Vehicle not in system."};
	
	private final String[] inspectionsCompleted = new String[inspectionChecklist.length];
	private final String[] inspectionsCompleted1 = new String[inspectionChecklist.length];
	private final String[] inspectionsCompleted2 = new String[inspectionChecklist.length];
        
        //All of these are example inspections for the example vehicles.
	
	private String finalResults;
        /**
         * Fetches the cost of the inspections to be made for a specific vehicle.
         * @param vehicle Vehicle which is to be inspected.
         * @return The cost of the inspection, if there are any inspections found.
         */
	public double fetchInspection(Vehicle vehicle){
		if(this.vehicle.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			System.out.println("inspections found! Your cost is: "+cost);
			return cost;
		}
		if(this.vehicle1.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			System.out.println("inspections found! Your cost is: "+cost);
			return cost;
		} 
		if(this.vehicle2.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			System.out.println("inspections found! Your cost is: "+cost);
			return cost;
		}
		else
			return 0;
	}
        /**
         * Checks if the vehicles registration number is the same as one in the database
         * then lists the inspections to be made and works through them,
         * while returning the next inspection each time.  
         * @param vehicle Vehicle to be inspected.
         * @return The current inspection in the form of a string.
         */   
	public String fetchInspectionChecklist(Vehicle vehicle){
		
		if(this.vehicle.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			System.out.println("Your inspections are: "+ Arrays.toString(inspectionChecklist));
			for(int i = currentInspectionCounter;i < inspectionChecklist.length; i++){
				String nextInspection = inspectionChecklist[i];
				System.out.println("The next Inspection is: "+nextInspection);
				System.out.println("working on--------"+nextInspection+"--------");
				currentInspectionCounter++;
				return nextInspection;          
			}
			return "No more inspections left";
		}
		if(this.vehicle1.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			System.out.println("Your inspections are: "+ Arrays.toString(inspectionChecklist1));
			for(int i = currentInspectionCounter;i < inspectionChecklist1.length; i++){
				String nextInspection = inspectionChecklist1[i];
				System.out.println("The next Inspection is: "+nextInspection);
				System.out.println("working on--------"+nextInspection+"--------");
				currentInspectionCounter++;
				return nextInspection;
			}
			return "No more inspections left";
		}
		if(this.vehicle2.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			System.out.println("Your inspections are: "+ Arrays.toString(inspectionChecklist2));
			for(int i = currentInspectionCounter;i < inspectionChecklist2.length; i++){
				String nextInspection = inspectionChecklist2[i];
				System.out.println("The next Inspection is: "+nextInspection);
				System.out.println("working on--------"+nextInspection+"--------");
				currentInspectionCounter++;
				return nextInspection;
			}
			return "No more inspections left";
		}
		else
			System.out.println(Arrays.toString(noCheckListFound));
			return Arrays.toString(noCheckListFound);
		
	}
        /**
         * Saves the result of the current inspection (always pass since dummy class).
         * @param currentCompletedInspection Name of the inspection to be saved.
         * @return An updated list of all the completed inspections so far.
         */
	public String saveCurrentResult(String currentCompletedInspection) {
		for(int i = saveCurrentInspectionCounter; i<inspectionChecklist.length; i++){
			inspectionsCompleted[i] = currentCompletedInspection + " PASS";
			System.out.println("saving results for-------inspectionNumber "+(i+1)+"--------");
			System.out.println("inspection Number "+(i+1)+" saved");
			System.out.println();
			saveCurrentInspectionCounter++;
			break;
		}
		finalResults = Arrays.toString(inspectionsCompleted);
		return finalResults;
                //Returns the stringarray as one long string
	}
	/**
         * Finds the final results of the specified vehicle.
         * @param vehicle The specified vehicle.
         * @return Final results (all the completed inspections done with results).
         */
	public String collectFinalResults(Vehicle vehicle){
		if(this.vehicle.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			return finalResults;
		}
		if(this.vehicle1.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			return finalResults;
		}
		if(this.vehicle2.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			return finalResults;
		}
		return "No results found";
	}
}