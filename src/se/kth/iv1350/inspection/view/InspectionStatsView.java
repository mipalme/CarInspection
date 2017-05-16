
package se.kth.iv1350.inspection.view;

import se.kth.iv1350.inspection.integration.Observer;

/**
 *  Displays the total amount of passed or failed inspections.
 * 
 */
public class InspectionStatsView implements Observer {
    int inspectionsPassed = 0;
    int inspectionsFailed = 0;
    
    public void CountPassOrFail (String result){
            
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
