
package se.kth.iv1350.inspection.model;

/**
 * This interface implements the strategy pattern, making instances of vehicles 
 * able to change between all-wheel-drive and two-wheel-drive.
 */
public interface Strategy {
    String driveType();   
}
/**
 * Changes a vehicle to have all-wheel-drive.
 */
class AllWheelDrive implements Strategy{
    /**
     * Gives vehicle a string describing that it has AWD.
     * @return Its all-wheel-drive attribute.
     */
    public String driveType(){
        return "This vehicle has all-wheel-drive";
    }
}
/**
 * Changes a vehicle to have two-wheel-drive.
 */
class TwoWheelDrive implements Strategy{
    /**
     * Gives vehicle a string describing that it was TWD.
     * @return Its two-wheel-drive attribute.
     */
    public String driveType(){
        return "This vehicle has two-wheel-drive";
    }
}
