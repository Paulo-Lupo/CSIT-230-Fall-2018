/*
 * Homework 1 - DecToFPN32x2.java
 * Joao Paulo D. S. Ferreira
 * CSIT 230 - Computer Systems
 * Dr. George Antoniou
 * September 07, 2018
 */

/* 
 * This program uses the built in method in java
 * to convert a number into its 32-bit FPN representation 
 */

public class DecToFPN32x2 {
	public static void main(String args[]) {
		/* reads the number */
		float num = (float) 12;
		
		/* uses built in method to convert it into 32-bit FPN */
		int intBits = Float.floatToIntBits(num);
		String binary = Integer.toBinaryString(intBits);
				
		/* prints the result */
		System.out.print(num + " = ");
		if(binary.length() < 32) {
			for (int i =0; i < (32 - binary.length()); i++)
				System.out.print(0);
			System.out.print(binary);
		} else {
			System.out.println(binary);
		}
	}
}
