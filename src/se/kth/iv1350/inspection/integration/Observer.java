
package se.kth.iv1350.inspection.integration;

/**
 * This interface 
 * 
 */
public interface Observer {
    /**
     * Blueprint for a method to be used that counts the passes and fails
     * of several inspections.
     * @param result The result of a single inspection (pass or fail).
     */
    public void countPassOrFail (String result); 
}
