
package se.kth.iv1350.inspection.data;

import java.util.Arrays;
import se.kth.iv1350.inspection.model.Vehicle;
import se.kth.iv1350.inspection.integration.Observer;
import se.kth.iv1350.inspection.view.InspectionStatsView;
/**
 * This class represents the non-existant database, and is filled with fabricated information about 
 * various example vehicles and inspections.
 * 
 */
public class Database {
  
	private final double cost = 1000;
	
	private final Vehicle vehicle = new Vehicle("ELF523");
	private final Vehicle vehicle1 = new Vehicle("LKF245");
	private final Vehicle vehicle2 = new Vehicle("LDK424");
        
	private final String[] inspectionChecklist = {"check oil","check windows","check lights"};
	private final String[] inspectionChecklist1 = {"check oil","check seats","check wheels"};
	private final String[] inspectionChecklist2 = {"check oil","check engine","check dashboard"};

	private final String[] inspectionsCompleted = new String[inspectionChecklist.length];
	private final String[] inspectionsCompleted1 = new String[inspectionChecklist.length];
	private final String[] inspectionsCompleted2 = new String[inspectionChecklist.length];
        
        private String finalResults;
        
        //All of these are example inspections for the example vehicles.
        public String[][] getInspectionChecklists(){
            String[][] checklists = new String[3][3];
            checklists[0] = inspectionChecklist;
            checklists[1] = inspectionChecklist1;
            checklists[2] = inspectionChecklist2;
            return checklists;
        }
        
        public Vehicle[] getRegisteredVehicles(){
            Vehicle[] vehicles = new Vehicle[3];
            vehicles[0] = vehicle;
            vehicles[1] = vehicle1;
            vehicles[2] = vehicle2;
            return vehicles;   
        }
        
        public double getCost(){
            return cost;
        }
        public void saveResults(String[] results){
            finalResults = Arrays.toString(results);
        }
        public String getResults(){
            return finalResults;
        }
        
        
               
	
	
}