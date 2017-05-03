
package se.kth.iv1350.inspection.integration;

public class Display {
    public int number;
    public void updateDisplay(int number){
        this.number = number;
        System.out.println("Current queue-number is: "+this.number);
    }
}
