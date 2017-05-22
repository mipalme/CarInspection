
package se.kth.iv1350.inspection.model;

import java.util.Arrays;
import se.kth.iv1350.inspection.integration.Observer;
import se.kth.iv1350.inspection.view.InspectionStatsView;
import se.kth.iv1350.inspection.integration.DatabaseManager;
/**
 * This class represents the inspection, and handles all the logic from the information gathered 
 * from the database.
 * 
 */
public class Inspection {
        DatabaseManager databaseManager = new DatabaseManager();
    
        private int currentInspectionCounter = 0;
	private int saveCurrentInspectionCounter = 0;
        private String result = "PASS";
        private InspectionStatsView observer;	
	private String finalResults;
                    
        private final String[] inspectionsCompleted = new String[databaseManager.retrieveInspectionChecklists().length];
	private final String[] inspectionsCompleted1 = new String[databaseManager.retrieveInspectionChecklists().length];
	private final String[] inspectionsCompleted2 = new String[databaseManager.retrieveInspectionChecklists().length];
 
        /**
         * Fetches the cost of the inspections to be made for a specific vehicle
         * as well as checks if the vehicle exists in the database.
         * @param vehicle Vehicle which is to be inspected.
         * @return The cost of the inspection, if there are any inspections found.
         * @throws InvalidVehicleException if the registration number is not found.
         */
	public double verifyVehicleAndGetCost(Vehicle vehicle) throws InvalidVehicleException{
		if(this.databaseManager.retrieveRegisteredVehicles()[0].getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
                        System.out.println(vehicle.getDriveType());
			return databaseManager.retrieveCost();
		}
		if(this.databaseManager.retrieveRegisteredVehicles()[1].getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
                        System.out.println(vehicle.getDriveType());
			return databaseManager.retrieveCost();
		} 
		if(this.databaseManager.retrieveRegisteredVehicles()[2].getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
                        System.out.println(vehicle.getDriveType());
			return databaseManager.retrieveCost();
		}
		else
			throw new InvalidVehicleException(vehicle.getRegistrationNumber());
	}
        /**
         * Finds the next inspection to be made for a vehicle.
         * @param vehicle The vehicle under inspection.
         * @return The next inspection that is on the checklist of the vehicle.
         */
        public String fetchNextInspection(Vehicle vehicle){
           for(int i = 0; i < databaseManager.retrieveRegisteredVehicles().length; i++){
			if(vehicle.getRegistrationNumber().equals(databaseManager.retrieveRegisteredVehicles()[i].getRegistrationNumber())){
				for(int j = currentInspectionCounter;j < databaseManager.retrieveInspectionChecklists().length; j++){
					String nextInspection = databaseManager.retrieveInspectionChecklists()[i][j];
					currentInspectionCounter++;
                                        System.out.println("working on--------"+nextInspection+"--------");
					return nextInspection;
				}
			}
		}
		return  "No inspections found";
        } 
        /**
         * Returns the entire checklist of inspections for a single vehicle.
         * @param vehicle the vehicle under inspection.
         * @return The inspection checklist for the vehicle.
         */
        public String checklistReturn(Vehicle vehicle){
		for(int i = 0; i < databaseManager.retrieveRegisteredVehicles().length; i++){
			if(vehicle.getRegistrationNumber().equals(databaseManager.retrieveRegisteredVehicles()[i].getRegistrationNumber())){
				String currentInspectionChecklist = Arrays.toString(databaseManager.retrieveInspectionChecklists()[i]);
				return currentInspectionChecklist;
			}
		}
		return  "Vehicle Not In System";
        }
      
        /**
         * Saves the result of the current inspection (always pass since no real inspector exists).
         * @param currentCompletedInspection Name of the inspection to be saved.
         */
	public void saveCurrentResult(String currentCompletedInspection) {
		for(int i = saveCurrentInspectionCounter; i<databaseManager.retrieveInspectionChecklists().length; i++){
			inspectionsCompleted[i] = currentCompletedInspection + " "+result;
                        notifyObserver(result);
			System.out.println("saving results for-------inspectionNumber "+(i+1)+"--------");
			System.out.println("inspection Number "+(i+1)+" saved");
			System.out.println();
			saveCurrentInspectionCounter++;
			break;
		}
                databaseManager.storeCurrentResult(inspectionsCompleted);                                    
	}
	/**
         * Finds the final results of the specified vehicle.
         * @param vehicle The specified vehicle.
         * @return Final results (all the completed inspections done with results).
         */
	public String collectFinalResults(Vehicle vehicle){
		if(this.databaseManager.retrieveRegisteredVehicles()[0].getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			return databaseManager.retrieveFinalResults();
		}
		if(this.databaseManager.retrieveRegisteredVehicles()[1].getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			return databaseManager.retrieveFinalResults();
		}
		if(this.databaseManager.retrieveRegisteredVehicles()[2].getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			return databaseManager.retrieveFinalResults();
		}
		return "No results found";
	}
        private void notifyObserver(String result){
            this.observer.countPassOrFail(result);
        }
        /**
         * Adds an observer.
         * @param observer The observer.
         */
        public void addObserver(InspectionStatsView observer){
            this.observer = observer;
        }
}
