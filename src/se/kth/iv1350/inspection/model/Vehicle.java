package se.kth.iv1350.inspection.model;
/**
 * This class handles the vehicle upon which the inspection is made.
 * 
 */
public class Vehicle {
	
	private final String registrationNumber;
        /**
         * Creates a new instance of the type Vehicle which contains a registration number.
         * @param registrationNumber The registration number of the vehicle.
         */
	public Vehicle(String registrationNumber){
		this.registrationNumber = registrationNumber;
	}
        /**
         * Finds out the registration number of the current instance of the vehicle.
         * @return the registration number in question.
         */
	public String getRegistrationNumber(){
		return this.registrationNumber;
	}
}