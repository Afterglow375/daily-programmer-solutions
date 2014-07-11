// Challenge #158 [Hard] Intersecting Rectangles
// http://bit.ly/1qRrBRO

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Daily169 {
	public static void main(String[] args) {
		File input = new File("src/input.txt");
		
		try {
			Scanner sc = new Scanner(input);
			int numCoords = sc.nextInt();
			String[] xyArr;
			ArrayList<Double[]> coordArr = new ArrayList<Double[]>(numCoords);
			
			for (int i = 0; i < numCoords; i++) {
				xyArr = sc.next().split(",");
				Double[] xyArrInts = {Double.parseDouble(xyArr[0]), Double.parseDouble(xyArr[1])};
				coordArr.add(xyArrInts);
			}
			
			for (int i = 0; i < numCoords-2; i++) {
				coordArr.get(0);
			}
			
//			Double[] vert1 = {-10, -10};
//			Double[] vert2 = {28, 15};
//			Double[] vert3 = {18, 7};
//			System.out.println(calcTriArea(vert1, vert2, vert3));
			
			sc.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static double calcTriArea(Double[] vert1, Double[] vert2, Double[] vert3) {
		return Math.abs((vert1[0]*(vert2[1] - vert3[1]) + vert2[0]*(vert3[1] - vert1[1]) + vert3[0]*(vert1[1] - vert2[1]))/2);
	}
}
