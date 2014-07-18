//[7/14/2014] Challenge #171 [Easy] Hex to 8x8 Bitmap
//Problem Link: http://bit.ly/1jFWisr

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Daily171E {
	public static void main(String[] args) {
		File input = new File("src/input.txt");
		
		try {
			// Read and parse input
			Scanner sc = new Scanner(input);
			String inputLine = sc.nextLine();
			String[] hexInput = inputLine.split(" ");
			char oneChar = 'O';
			char zeroChar = ' ';
			
			// Outputting the binary string, replacing the 1's with oneChar and 0's with zeroChar
			for (int i = 0; i < hexInput.length; i++) {
				System.out.println(hexToBin(hexInput[i]).replace('1', oneChar).replace('0', zeroChar));
			}
			
			sc.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// Turns a hexadecimal digit string into a binary digit string
	public static String hexToBin(String hexStr) {
		int hexInt = Integer.parseInt(hexStr, 16);
		String binStr = Integer.toBinaryString(hexInt);
		
		// Need to pad with 0s if necessary
		while (binStr.length() < 8) {
			binStr = '0' + binStr;
		}
		
		return binStr;
	}
}

