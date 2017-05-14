
package se.kth.iv1350.inspection.integration;
/**
 * This class handles the garage where the inspection takes place,
 * the garage also contains the display which shows what customer should be served.
 * 
 */
public class Garage {
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