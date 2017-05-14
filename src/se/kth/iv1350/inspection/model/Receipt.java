package se.kth.iv1350.inspection.model;
/**
 * This class handles the receipt that is printed when the inspection is completed.
 * 
 */
public class Receipt {
        
	private double cost;
	
	/**
         * Creates a new instance of a Receipt which contains the cost of the entire inspection.
	 * 
	 * @param cost. The cost for the full inspection.
	 */
	public Receipt(double cost){
		
	}
	/**
	 * 
	 * @return The cost for the full inspection.
	 */
	public double getCost() {
		return cost;
	}
}
