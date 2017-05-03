
package se.kth.iv1350.inspection.data;

import java.util.Arrays;

import se.kth.iv1350.inspection.integration.Printer;
import se.kth.iv1350.inspection.model.Vehicle;

public class Database {
	
	public int currentInspectionCounter = 0;
	public int saveCurrentInspectionCounter = 0;

	public static final double cost = 1000;
        
        //An example value for the cost of an inspection. 
        //It was never specified how the cost is to be caculated, 
        //so we have just put it as a static number
	
	Vehicle vehicle = new Vehicle("ELF523");
	Vehicle vehicle1 = new Vehicle("LKF245");
	Vehicle vehicle2 = new Vehicle("LDK424");
        
        //Three example vehicles.
	
	private final String[] inspectionChecklist = {"check oil","check windows","check lights"};
	private final String[] inspectionChecklist1 = {"check oil","check seats","check wheels"};
	private final String[] inspectionChecklist2 = {"check oil","check engine","check dashboard"};
	private final String[] noCheckListFound = {"Vehicle not in system."};
	
	private final String[] inspectionsCompleted = new String[inspectionChecklist.length];
	private final String[] inspectionsCompleted1 = new String[inspectionChecklist.length];
	private final String[] inspectionsCompleted2 = new String[inspectionChecklist.length];
        
        //All of these are example inspections for the example vehicles.
	
	private String finalResults;
       
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
          //Checks if the vehicles registration number is the same as one in the database,
          //Then lists the inspections to be made and works through them, while returning the next inspection each time.     
	public String fetchInspectionChecklist(Vehicle vehicle){
		
		if(this.vehicle.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			System.out.println("Your inspections are: "+ Arrays.toString(inspectionChecklist));
			for(int i = currentInspectionCounter;i < inspectionChecklist.length; i++){
				String nextInspection = inspectionChecklist[i];
				System.out.println("The next Inspection are: "+nextInspection);
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
				System.out.println("The next Inspection are: "+nextInspection);
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
				System.out.println("The next Inspection are: "+nextInspection);
				System.out.println("working on--------"+nextInspection+"--------");
				currentInspectionCounter++;
				return nextInspection;
			}
			return "No more inspections left";
		}
		else
			System.out.println(Arrays.toString(noCheckListFound));
			return  Arrays.toString(noCheckListFound);
		
	}
	public String saveCurrentResult(String currentCompletedInspection) {
		for(int i = saveCurrentInspectionCounter; i<inspectionChecklist.length; i++){
			inspectionsCompleted[i] = currentCompletedInspection;
			System.out.println("saving results for-------inspectionNumber "+(i+1)+"--------");
			System.out.println("inspection Number "+(i+1)+" saved");
			System.out.println();
			saveCurrentInspectionCounter++;
			break;
		}
		finalResults = Arrays.toString(inspectionsCompleted);
		return Arrays.toString(inspectionsCompleted);
                //Returns the stringarray as one long string
	}
	
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