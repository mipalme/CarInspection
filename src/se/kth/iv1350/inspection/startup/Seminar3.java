
package se.kth.iv1350.inspection.startup;

import se.kth.iv1350.inspection.controller.Controller;
import se.kth.iv1350.inspection.view.View;
/**
 * This class contains the main method and is run upon startup.
 * 
 */
public class Seminar3 {

	/**
         * The main method that initiates the program sequence.
         * @param args 
         */
	public static void main(String[] args) {
	
		/**
		 * Creates a new instance of the controller object and view object.
		 */
		Controller controller = new Controller();
                View view = new View(controller);
		/**
		 * Different system operations that will be tested.
		 */                             
                view.testSystemOperations();         	
	}
}