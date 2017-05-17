
package se.kth.iv1350.inspection.integration;
/**
 * This class handles the garage where the inspection takes place,
 * the garage also contains the display which shows what customer should be served.
 * 
 */
public class Garage {
        private static Garage firstInstance = null;
    
        private Garage(){}
        /**
        * Checks is an instance of the object already exists, returns an instance of the object
        * of no such object exists currently (singleton).
        * @return An instance of the object.
        */
        public static Garage getInstance(){
        
        if(firstInstance == null){
            firstInstance = new Garage();
        }
        return firstInstance;
    } 
	/**
         * Opens the garage door.
         */
	public void openDoor(){
		System.out.println("Door has been opened");
	}
	/**
         * Closes the garage door.
         */
	public void closeDoor(){
		System.out.println("Door has been closed");
	}
	/**
	 * Updates the display with a new number.
	 * @param number. The number that the display will show.
	 */
	public void updateDisplay(int number){
		System.out.println("Display has been updated with the number: "+number);
	}
}