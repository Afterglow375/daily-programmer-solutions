// [7/16/2014] Challenge #171 [Intermediate] Zoom, Rotate, Invert Hex Picture
// Problem Link: http://bit.ly/1rvUeWm

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Daily171I {
	public static ArrayList<String> image = new ArrayList<String>(8);
	public static int dimension;
	
	public static void main(String[] args) {
		File input = new File("src/input.txt");
		
		try {
			// Read and parse input
			Scanner sc = new Scanner(input);
			String inputLine = sc.nextLine();
			String[] hexInput = inputLine.split(" ");
			char oneChar = 'O';
			char zeroChar = ' ';
			
			// Creating the binary string, replacing the 1's with oneChar and 0's with zeroChar
			for (int i = 0; i < hexInput.length; i++) {
				image.add(hexToBin(hexInput[i]).replace('1', oneChar).replace('0', zeroChar));
			}
			dimension = image.size();
			
			// Manipulating the image
			zoomIn();
			printImage();
			rotate();
			printImage();
			zoomIn();
			printImage();
			invert(oneChar, zeroChar);
			printImage();
			zoomOut();
			printImage();
			
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
	
	// Prints the contents of the image ArrayList
	public static void printImage() {
		for (int i = 0; i < dimension; i++) {
			System.out.println(image.get(i));
		}
		System.out.println("===========================");
	}
	
	// Zooms in by extending a line 2x then duplicating it
	public static void zoomIn() {
		String inputLine, outputLine;
		for (int i = 0; i < dimension*2; i+=2) {
			
			inputLine = image.get(i);
			outputLine = "";
			for (int j = 0; j < dimension; j++) {
				outputLine += new StringBuilder().append(inputLine.charAt(j)).append(inputLine.charAt(j)).toString();
			}
			
			image.set(i, outputLine);
			image.add(i, outputLine);
		}
		dimension = dimension*2;
	}
	
	// Zooms out by cutting each line in half and deleting every other line
	public static void zoomOut() {
		String inputLine, outputLine;
		for (int i = 0; i < dimension/2; i++) {
			
			inputLine = image.get(i);
			outputLine = "";
			for (int j = 0; j < dimension; j+=2) {
				outputLine += inputLine.charAt(j);
			}
			
			image.set(i, outputLine);
			image.remove(i+1);
		}
		dimension = dimension/2;
	}
	
	// Swaps the oneChar with the zeroChar in the image, inverting the image
	public static void invert(char oneChar, char zeroChar) {
		String inputLine, outputLine;
		for (int i = 0; i < dimension; i++) {
			
			inputLine = image.get(i);
			outputLine = "";
			for (int j = 0; j < dimension; j++) {
				if (inputLine.charAt(j) == oneChar) {
					outputLine += zeroChar;
				} 
				else {
					outputLine += oneChar;
				}
			}
			
			image.set(i, outputLine);
		} 
	}
	
	// Rotates image 90 degrees clockwise
	public static void rotate() {
		ArrayList<String> copy = new ArrayList<String>(dimension);
		for (int i = 0; i < dimension; i++) {
			String outputLine = "";
			for (int j = 0; j < dimension; j++) {
				outputLine = image.get(j).charAt(i) + outputLine;
			}
			copy.add(outputLine);
		}
		image = new ArrayList<String>(copy);
	}
}

