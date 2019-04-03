/*
 * Homework 1 - DecToFPN32.java
 * Joao Paulo D. S. Ferreira
 * CSIT 230 - Computer Systems
 * Dr. George Antoniou
 * September 07, 2018
 */

/* The following program converts a decimal number into its 32-bit FPN representation */

public class DecToFPN32 {
	public static void main(String args[]) {
		
		/* reads the decimal representation of the number */
		int decNumInt = 12;
		
		/* determines the bit value of the sign */
		int s = 0;
		if(decNumInt < 0) {
			s = 1;
		}
		
		/* 
		 * gets the absolute value of the number
		 * the program does not need to care about the sign anymore 
		 */
		int positiveNum = Math.abs(decNumInt);
		
		
		int i = 0;
		int unbiasExpo = 0;
		int indexHolder = 0;
		
		/* finds the unbiased exponent */
		while (Math.pow(2, i) <= positiveNum) {
			indexHolder = i;
			i++;
		}
		unbiasExpo = indexHolder;
				
		/* 
		 * finds and converts the biased exponent into
		 * its 8-bit binary form and stores it in as array	
		 */	
		int biasedExpo = 127 + unbiasExpo;
		int[] biasExponentBin = new int[8];
		for(i = 7; i >= 0; i--) {
			biasExponentBin[i] = biasedExpo%2;
			biasedExpo /= 2;
		}
			
		/* converts the number into its binary form and stores it in an array */
		int[] binNumber = new int[unbiasExpo+1];
		while (positiveNum > 0) {
			binNumber[indexHolder] = positiveNum%2;				
			positiveNum = positiveNum/2;
			indexHolder--;
		}
			
		/* creates and populates the mantissa in an array */
		int[] mantissa = new int[23];
		for(i = 0; i < 23; i++) {
			if (i < unbiasExpo) {
			mantissa[i] = binNumber[i+1];
			}
		}
		
		/* prints the result */
		System.out.print(decNumInt + " = " + s + " ");
		for(i = 0; i < 8; i++) {
			System.out.print(biasExponentBin[i]);
		}
		System.out.print(" ");
		for(i = 0; i < 23; i++) {
				System.out.print(mantissa[i]);
		}
	}
}
