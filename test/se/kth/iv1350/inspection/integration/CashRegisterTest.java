/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.inspection.integration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class CashRegisterTest {
    
    public CashRegisterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testUpdateCash() {
        System.out.println("updateCash");
        double cost = 0.0;
        CashRegister instance = new CashRegister();
        instance.updateCash(cost);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalculateChange() {
        System.out.println("calculateChange");
        double cost = 0.0;
        double amountPayed = 0.0;
        CashRegister instance = new CashRegister();
        double expResult = 0.0;
        double result = instance.calculateChange(cost, amountPayed);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
