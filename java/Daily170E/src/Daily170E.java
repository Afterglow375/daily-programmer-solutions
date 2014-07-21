// [7/7/2014] Challenge #170 [Easy] Blackjack Checker
// Problem Link: http://bit.ly/UntKry

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Daily170E {
	public static void main(String[] args) {
		File input = new File("src/input.txt");

		try {
			// Read and parse input
			Scanner sc = new Scanner(input);
			int numLines = sc.nextInt();
			
			for (int i = 0; i < numLines; i++) {
				
			}

			sc.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}