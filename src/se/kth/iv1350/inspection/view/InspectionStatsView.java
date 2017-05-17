
package se.kth.iv1350.inspection.view;

import se.kth.iv1350.inspection.integration.Observer;

/**
 *  Counts and displays the total amount of passed or failed inspections.
 * 
 */
public class InspectionStatsView implements Observer {
    int inspectionsPassed = 0;
    int inspectionsFailed = 0;
    /**
     * Keeps track of how many PASS or FAIL results
     * have been scored so far.
     * @param result The result of a single inspection, containing one PASS or FAIL.
     */
    public void countPassOrFail (String result){      
            if (result.equals("PASS")){
                inspectionsPassed++;
            }
            else if (result.equals("FAIL")){
                inspectionsFailed++;
            }
            String results = "Passed inspections: "+inspectionsPassed+". Failed inspections: "+inspectionsFailed+".";
            System.out.println(results);
    }
}
