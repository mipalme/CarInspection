package se.kth.iv1350.inspection.model;
/**
 * This class handles the vehicle upon which the inspection is made.
 * 
 */
public class Vehicle {
	
	private final String registrationNumber;
        /**
         * Instance variable describing the vehicles driving type.
         */
        public Strategy driveType;
        /**
         * Checks the vehicles driving type.
         * @return The vehicles driving type. 
         */
        public String getDriveType(){
            return driveType.driveType();
        }
        /**
         * Changes a vehicles driving type.
         * @param newDriveType The new driving type.
         */
        public void setDriveType(Strategy newDriveType){
            driveType = newDriveType;
        }
        /**
         * Creates a new instance of the type Vehicle which contains a registration number,
         * all vehicles have all-wheel-drive by default.
         * @param registrationNumber The registration number of the vehicle.
         */
	public Vehicle(String registrationNumber){
		this.registrationNumber = registrationNumber;
                driveType = new AllWheelDrive();
	}
        /**
         * Finds out the registration number of the current instance of the vehicle.
         * @return the registration number in question.
         */
	public String getRegistrationNumber(){
		return this.registrationNumber;
	}
}