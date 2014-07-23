// [7/2/2014] Challenge #169 [Intermediate] Home-row Spell Check
// Problem Link: http://bit.ly/Usys7t

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Daily169I {
	public static final String[] KEY_ROWS = { "qwertyuiop", "asdfghjkl", "zxcvbnm", "QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM" };
	
	public static void main(String[] args) {
		File input = new File("src/input.txt");
		File words = new File("src/words.txt");
		
		try {
			// Read and parse input
			Scanner inputScanner = new Scanner(input);
			String outputStr = "";
			
			while (inputScanner.hasNext()) {
				String rawWord = inputScanner.next();
				String cleanedWord = rawWord.replaceAll("[^A-Za-z]", "");
				String lowerCleanedWord = cleanedWord.toLowerCase();
				
				// Create the shifted words for each input word
				String oneLeft = shiftWord(cleanedWord, -1);
				String twoLeft = shiftWord(cleanedWord, -2);
				String oneRight = shiftWord(cleanedWord, 1);
				String twoRight = shiftWord(cleanedWord, 2);
				String lowerOneLeft = oneLeft.toLowerCase();				
				String lowerTwoLeft = twoLeft.toLowerCase();
				String lowerOneRight = oneRight.toLowerCase();
				String lowerTwoRight = twoRight.toLowerCase();
				
				Scanner wordScanner = new Scanner(words);
				
				// Build up the outputWord
				String outputWord = "{";
				while (wordScanner.hasNext()) {
					String comparingWord = wordScanner.next();
					if (lowerCleanedWord.equals(comparingWord)) {
						outputWord = cleanedWord;
						break;
					}
					else if (lowerOneLeft.equals(comparingWord)) {
						outputWord += oneLeft + " ";
					}
					else if (lowerTwoLeft.equals(comparingWord)) {
						outputWord += twoLeft + " ";
					}
					else if (lowerOneRight.equals(comparingWord)) {
						outputWord += oneRight + " ";
					}
					else if (lowerTwoRight.equals(comparingWord)) {
						outputWord += twoRight + " ";
					}
				}
				
				// If substituted words found, remove the last white space and add a closing brace
				if (outputWord.charAt(0) == '{') { 
					outputWord = outputWord.substring(0, outputWord.length()-1);
					outputWord += '}';
				}
				
				outputStr += rawWord.replaceAll(cleanedWord, outputWord) + " ";
				wordScanner.close();
			}
			
			System.out.println(outputStr);
			inputScanner.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// Shifts the given word by a certain number left or right, abiding by the rules given in the problem
	public static String shiftWord(String alteredWord, int shiftBy) {
		String outputStr = "";
		for (int i = 0; i < alteredWord.length(); i++) {
			char ch = alteredWord.charAt(i);
			for (int j = 0; j < KEY_ROWS.length; j++) {
				int charIndex = KEY_ROWS[j].indexOf(ch);
				if (charIndex != -1) {
					int newIndex = shiftBy + charIndex;
					if (newIndex >= 0) {
						outputStr += KEY_ROWS[j].charAt((newIndex) % KEY_ROWS[j].length());
					}
					else {
						outputStr += KEY_ROWS[j].charAt(KEY_ROWS[j].length() + charIndex + shiftBy);
					}
				}
			}
		}
		return outputStr;
	}
}
