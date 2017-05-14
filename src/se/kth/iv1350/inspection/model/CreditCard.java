
package se.kth.iv1350.inspection.model;
/**
 * This class handles the credit card which the customer pays with (unless the payment is cash).
 * 
 */
public class CreditCard {
	
	private int pin;
	private String number;
	private String holder;
	private int expireDate;
	private int CVC;
        
        /**
         * Creates a new instance of the type credit card which contains the following values.
         * 
         * @param pin the pin number of the card.
         * @param number the credit card number.
         * @param holder the holder of the card.
         * @param expireDate the cards expiration date.
         * @param CVC the CVC number of the card.
         */
	
	public CreditCard(int pin, String number, String holder, int expireDate, int CVC){
		
	}
	/**
         * Finds out the holder of the current instance of the credit card.
         * @return the holder in question.
         */
	public String getHolder(){
		return this.holder;
	}
        /**
         * Finds out the pin number of the current instance of the credit card.
         * @return the pin number in question.
         */
	public int getPin(){
		return this.pin;
	}
	/**
         * Finds out the credit card number of the current instance of the credit card.
         * @return the number in question.
         */       
	public String getNumber(){
		return this.number;
	}
        /**
         * Finds out the expiration date of the current instance of the credit card.
         * @return the date in question.
         */
	public int getExpireDate(){
		return this.expireDate;
	}
        /**
         * Finds out the CVC of the current instance of the credit card.
         * @return the CVC in question.
         */
	public int getCVC(){
		return this.CVC;
	}
}
