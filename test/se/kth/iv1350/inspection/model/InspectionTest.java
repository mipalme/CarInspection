
package se.kth.iv1350.inspection.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class InspectionTest {
    
    public InspectionTest() {
    }
    private final double cost = 1000;
    Vehicle vehicle;
    Inspection instance;
    
    @Before
    public void setUp() {
        vehicle = new Vehicle("ELF523");
        instance = new Inspection();
    }
    
    @After
    public void tearDown() {
        vehicle = null;
        instance = null;
    }

    @Test
    public void testFetchInspection() throws InvalidVehicleException {
        System.out.println("fetchInspection");
        double expResult = cost;
        double result = instance.verifyVehicleAndGetCost(vehicle);
        assertEquals(expResult, result, 0.0);
    }
    //the next inspection at this point in time is the "check oil" inspection
    @Test
    public void testFetchInspectionChecklist() {
        System.out.println("fetchInspectionChecklist");
        String expResult = "check oil";
        String result = instance.fetchNextInspection(vehicle);
        assertEquals(expResult, result);
    }

    @Test
    public void testSaveCurrentResult() {
        System.out.println("saveCurrentResult");
        instance.saveCurrentResult("check oil");
        instance.saveCurrentResult("check windows");
        String expResult = "[check oil PASS, check windows PASS, check lights PASS]";
       // String result = instance.saveCurrentResult("check lights");
       // assertEquals(expResult, result);
    }
    @Test
    public void testCollectFinalResults() {
        System.out.println("collectFinalResults");
        instance.saveCurrentResult("check oil");
        instance.saveCurrentResult("check windows");
        instance.saveCurrentResult("check lights");
        String expResult = "[check oil PASS, check windows PASS, check lights PASS]";
        String result = instance.collectFinalResults(vehicle);
        assertEquals(expResult, result);
    }   
}
