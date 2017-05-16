
package se.kth.iv1350.inspection.model;

/**
 * Throws exception if vehicle with given registration number is not found.
 * 
 */
public class InvalidVehicleException extends Exception {
    
    public InvalidVehicleException(String regNumber){
        super("Vehicle with registration number "+regNumber+" could not be found.");   
    }   
}
