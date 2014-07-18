// Challenge 
// Problem Link: 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DailyTemplate {
	public static void main(String[] args) {
		File input = new File("src/input.txt");
		
		try {
			// Read and parse input
			Scanner sc = new Scanner(input);
			int numLines = sc.nextInt();
			
			sc.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
