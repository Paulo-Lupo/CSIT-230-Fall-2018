/*
 * Homework 1 - BinaryHexa.java
 * Joao Paulo D. S. Ferreira
 * CSIT 230 - Computer Systems
 * Dr. George Antoniou
 * September 07, 2018
 */

/* This program converts binary numbers into hexadecimal and back */

import java.util.Scanner;

public class BinaryHexa {
	public static void main(String args[]) {
		
		/* asks the user for a binary number and reads the input */
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a Binary Number to be converted into Hexadecimal: ");
		String binNumber = scan.next();
		
		/* finds the decimal representation of the binary number */
		int i = 0;
		int decNumber = 0;
		for (i = 0; i < binNumber.length(); i++) {
			decNumber += Integer.parseInt(binNumber.substring(i, i+1))*Math.pow(2, binNumber.length()-1-i);
		}
		
		/* finds how many elements the hexadecimal number has */
		i = 0;
		int indexHolder = 0;
		while (Math.pow(16, i) <= decNumber) {
			indexHolder = i;
			i++;
		}
		i = indexHolder;

		/* finds the Hexadecimal representation of the number and stores it in an array */
		String[] hex = new String[i+1];
		hex[0] = "0";
		while(decNumber > 0) {
			switch (decNumber%16) {
			case 10: {
				hex[i] = "A";
				break;
			}
			case 11: {
				hex[i] = "B";
				break;
			}
			case 12: {
				hex[i] = "C";
				break;
			}			
			case 13: {
				hex[i] = "D";
				break;
			}			
			case 14: {
				hex[i] = "E";
				break;
			}			
			case 15: {
				hex[i] = "F";
				break;
			}
			default: {
				hex[i] = Integer.toString(decNumber%16);
			}
			}
			decNumber = decNumber/16;
			i--;
		}
		
		/* prints the results */
		System.out.print(binNumber + " in hexadecimal is: ");
		for(i = 0; i <= indexHolder; i++) {
			System.out.print(hex[i]);
		}
		
		/* converts the hexadecimal number into its decimal form */
		decNumber = 0;
		for (i = 0; i <= indexHolder; i++) {
			switch (hex[indexHolder-i]) {
			case "A": {
				decNumber += (int) (10*Math.pow(16, i));
				break;
			}			
			case "B": {
				decNumber += (int) (11*Math.pow(16, i));
				break;
			}			
			case "C": {
				decNumber += (int) (12*Math.pow(16, i));
				break;
			}			
			case "D": {
				decNumber += (int) (13*Math.pow(16, i));
				break;
			}			
			case "E": {
				decNumber += (int) (14*Math.pow(16, i));
				break;
			}			
			case "F": {
				decNumber += (int) (15*Math.pow(16, i));
				break;
			}
			default: {
				decNumber += (int) (Integer.parseInt(hex[indexHolder-i])*Math.pow(16, i));
			}
			}
		}
		
		/* finds how many elements the binary number has */
		int indexHolder2 = 0;
		while (Math.pow(2, i) <= decNumber) {
			indexHolder2 = i;
			i++;
		}
		i = indexHolder2;
		
		/* converts the number into binary form and stores it in an array */
		int[] binNum = new int[i+1];
		while (decNumber > 0) {
			binNum[i] = decNumber%2;
			decNumber = decNumber/2;
			i--;	
		}
		
		/* prints the result */
		System.out.println();
		for(i = 0; i <= indexHolder; i++) {
			System.out.print(hex[i]);
		}
		System.out.print(" in binary is: ");
		for(i = 0; i <= indexHolder2; i++) {
			System.out.print(binNum[i]);
		}
	}
}
