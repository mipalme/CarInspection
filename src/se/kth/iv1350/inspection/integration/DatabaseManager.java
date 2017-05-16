
package se.kth.iv1350.inspection.integration;

import se.kth.iv1350.inspection.data.Database;
import se.kth.iv1350.inspection.model.Vehicle;
import se.kth.iv1350.inspection.data.InvalidVehicleException;
/**
 * This class serves as the middleman between database and controller, it is the only class
 * that calls from the database.
 *
 */
public class DatabaseManager {	
	/**
	 * New instance of the database class.
	 */
	Database database = new Database();

	/**
	 * Looks if there are any inspections associated with the vehicle, 
         * and also checks the cost.
	 * @param vehicle. Vehicle which holds the registration number connected to the inspections.
	 * @return The cost of the full inspection (if there is an inspection to be found).
         * @throws InvalidVehicleException if no vehicle with given registration number is found.
	 */
	public double findInspection(Vehicle vehicle) throws InvalidVehicleException{
		return database.fetchInspection(vehicle);
	}
        /**
         * Fetches the list of inspections associated with the current vehicle.
         * @param vehicle The vehicle under inspection.
         * @return All inspections associated with the vehicle.
         */
        public String getInspectionChecklist(Vehicle vehicle){
            return database.fetchInspectionChecklist(vehicle);
        }
	/**
	 * Goes through the inspections associated to the specified vehicle, while returning the next
         * inspection in the list.
	 * @param vehicle. The vehicle under inspection.
	 * @return If there is an inspectionChecklist for the given vehicle the next inspection on that checklist will be returned.
	 */
	public String findInspectionChecklist(Vehicle vehicle){
		return database.fetchNextInspection(vehicle);
	}
	/**
	 * Stores the current result together with the previous results in a new updated result.
	 * @param currentCompletedInspection The current inspection on the inspectionChecklist.
	 */
	public void storeCurrentResult(String currentCompletedInspection){
		database.saveCurrentResult(currentCompletedInspection);
	}
	/**
	 * Finds the final result of the specified vehicle in the form of one long string.
	 * @param vehicle. The vehicle associated with the result you want access to.
	 * @return Returns the corresponding final results for the given vehicle. 
	 */
	public String findFinalResult(Vehicle vehicle){
		return database.collectFinalResults(vehicle);
	}
}
