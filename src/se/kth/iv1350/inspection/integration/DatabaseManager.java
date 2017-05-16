
package se.kth.iv1350.inspection.integration;

import se.kth.iv1350.inspection.data.Database;
import se.kth.iv1350.inspection.model.Vehicle;
import se.kth.iv1350.inspection.model.InvalidVehicleException;

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
         * Retrieves the inspection checklists from the database.
         * @return The inspection checklists.
         */
        public String[][] retrieveInspectionChecklists(){
            return database.getInspectionChecklists();
        }
        /**
         * Retrieves the registered vehicles from the database.
         * @return The registered vehicles.
         */
        public Vehicle[] retrieveRegisteredVehicles(){
            return database.getRegisteredVehicles();
        }
        /**
         * Retrieves the cost of the inspection from the database.
         * @return The cost of the inspection.
         */ 
        public double retrieveCost(){
            return database.getCost();
        }
        public void saveCurrentResult(String[] result){
            database.saveResults(result);
        }
        public String retrieveFinalResults(){
            return database.getResults();
        }
        

}
