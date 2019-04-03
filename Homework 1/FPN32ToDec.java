/*
 * Homework 1 - FPN32ToDec.java
 * Joao Paulo D. S. Ferreira
 * CSIT 230 - Computer Systems
 * Dr. George Antoniou
 * September 07, 2018
 */


/* This program converts a 32-bit FPN into its decimal equivalent */

public class FPN32ToDec {
	public static void main(String args[]) {
		
		/* 32-bit FPN representation of the number */
		String number = "1 10000010 00100000000000000000000";
		
		/* reads the first bit to determine whether it is a positive or negative number */
		int s = Integer.parseInt(number.substring(0, 1));
		
		/* reads the 8bit representation of the biased exponent */
		String biasExpBin = number.substring(2, 10);
		
		/* finds the decimal representation of the biased exponent */
		int biasExpDec = 0;
		for (int i = 0; i < 8; i++) {
			biasExpDec += (int) Integer.parseInt(biasExpBin.substring(i, i+1))*Math.pow(2, (7-i));
		}
		
		/* finds the decimal representation of the unbiased exponent */
		int unbiasExpDec = biasExpDec - 127;

		/* reads the mantissa */
		String mantissaBin = number.substring(11,34);
		
		/* 
		 * Finds the decimal value of the normalized number
		 * Method to find it changes based on the value of the unbiased exponent
		 */	
		double decNumber = 0;
		if (unbiasExpDec > 0) {
			
			/* gets the binary representation of the number */
			String binNumber = "1"+ mantissaBin.substring(0,unbiasExpDec);
			
			/* finds the decimal representation of the number */
			for (int i = 0; i < binNumber.length(); i++) {
				decNumber += Integer.parseInt(binNumber.substring(i, i+1))*Math.pow(2, binNumber.length()-1-i);
			}
			
		} else if (unbiasExpDec == 0) {
			mantissaBin = "1"+ mantissaBin;
			for (int i = 0; i < 23; i++) {
				decNumber += Double.parseDouble(mantissaBin.substring(i, i+1))/Math.pow(2, i);
			}
		} else {
			mantissaBin = "1"+ mantissaBin;
			for (int i = 0; i < 23; i++) {
				decNumber += Double.parseDouble(mantissaBin.substring(i, i+1))/Math.pow(2, i+1);
			}
		}
			
		/* prints the result */
		if(s == 1) {
			decNumber = decNumber*(-1);
			System.out.println(number + " = " + decNumber);
		} else {
			System.out.println(number + " = "  + decNumber);
		}
	}
}
