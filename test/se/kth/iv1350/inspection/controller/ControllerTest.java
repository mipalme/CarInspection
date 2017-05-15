
package se.kth.iv1350.inspection.controller;
import se.kth.iv1350.inspection.model.Vehicle;
import se.kth.iv1350.inspection.model.CreditCard;
import se.kth.iv1350.inspection.data.InvalidVehicleException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ControllerTest {
    
    public ControllerTest() {
    }
    Controller instance;
    Vehicle vehicle;
    CreditCard creditcard;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Controller();
        vehicle = new Vehicle("ELF523");
        creditcard = new CreditCard(1111,"1111 1111 1111 1111","julius caesar",1019,111);  
    }
    
    @After
    public void tearDown() {
        instance = null;
        vehicle = null;
        creditcard = null;
    }

    @Test
    public void testNewInspection() {
        System.out.println("newInspection");
        int number = 0;
        instance.newInspection(number);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testRegisterCashPayment() {
        System.out.println("registerCashPayment");
        double cost = 10;
        double amountPayed = 15;
        double expResult = amountPayed - cost;
        double result = instance.registerCashPayment(cost, amountPayed);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testVerifyVehicle() throws InvalidVehicleException {
        System.out.println("verifyVehicle");
        String registrationNumber = vehicle.getRegistrationNumber();
        double expResult = 1000;
        double result = instance.verifyVehicle(registrationNumber);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testRegisterCardPayment() {
        System.out.println("registerCardPayment");
        int pin = 0;
        String number = creditcard.getNumber();
        String holder = creditcard.getHolder();
        int expireDate = creditcard.getExpireDate();
        int CVC = creditcard.getCVC();
        Double cost = 100.0;
        boolean result = instance.registerCardPayment(pin, number, holder, expireDate, CVC, cost);
        assertTrue(result);
    }

    @Test
    public void testFetchNextInspectionAndStoreResults() {
        System.out.println("fetchNextInspectionAndStoreResults");
        String registrationNumber = vehicle.getRegistrationNumber();
        String expResult = "No inspections left";
        String result = instance.fetchNextInspectionAndStoreResults(registrationNumber);
        assertEquals(expResult, result);
    }

    @Test
    public void testMapCurrentResult() {
        System.out.println("mapCurrentResult");
        String currentCompletedInspection = "";
        instance.mapCurrentResult(currentCompletedInspection);
    }

    @Test
    public void testPrintCurrentResult() {
        System.out.println("printCurrentResult");
        String registrationNumber = vehicle.getRegistrationNumber();
        instance.printCurrentResult(registrationNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
