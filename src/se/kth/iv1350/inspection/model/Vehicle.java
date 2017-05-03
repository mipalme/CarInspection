package se.kth.iv1350.inspection.model;

public class Vehicle {
	
	/**
	 * This class creates the vehicle object which holds a registration number.
	 */
	//.
	private String registrationNumber;
	public Vehicle(String registrationNumber){
		this.registrationNumber = registrationNumber;
	}
	public String getRegistrationNumber(){
		return this.registrationNumber;
	}
}