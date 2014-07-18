// Challenge #169 [Hard] Convex Polygon Area
// Problem Link: http://bit.ly/1qRrBRO

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Daily169 {
	public static void main(String[] args) {
		File input = new File("src/input.txt");
		
		try {
			// Read and parse input
			Scanner sc = new Scanner(input);
			int numCoords = sc.nextInt();
			String[] xyArr;
			ArrayList<Point> coordArr = new ArrayList<Point>(numCoords);
			
			for (int i = 0; i < numCoords; i++) {
				xyArr = sc.next().split(",");
				Point point = new Point(Double.parseDouble(xyArr[0]), Double.parseDouble(xyArr[1]));
				coordArr.add(point);
			}
			
			// Divides up the polygon with non-overlapping triangles that all share an anchor point
			// Find an adjacent point of the anchor point
			Point anchor = coordArr.remove(0); // Arbitrarily chosen
			Point randomPoint = coordArr.get(0); // Arbitrarily chosen
			Point adjacentPoint;
			int adjacentPointIndex = 0;
			double maxAngleSoFar = 0;
			double angle = 0;
			
			// Find an adjacent point to the anchor
			for (int i = 0; i < coordArr.size(); i++) {
				angle = anchor.calcAngle(randomPoint, coordArr.get(i));
				if (angle > maxAngleSoFar) {
					maxAngleSoFar = angle;
					adjacentPointIndex = i;
				}
			}
			
			adjacentPoint = coordArr.remove(adjacentPointIndex);
			
			// Insertion sort to sort the points in sequential fashion
			for (int i = 1; i < coordArr.size(); i++) {
				int j = i;
				Point point = coordArr.get(i);
				angle = anchor.calcAngle(adjacentPoint, point);
				while (j > 0 && anchor.calcAngle(adjacentPoint, coordArr.get(j-1)) > angle) {
					coordArr.set(j, coordArr.get(j-1));
					j--;
				}
				coordArr.set(j, point);
			}
			
			coordArr.add(0, adjacentPoint);
			
			// Add up areas of the non-overlapping triangles
			double area = 0;
			for (int i = 0; i < coordArr.size()-1; i++) {
				area += anchor.calcTriangleArea(coordArr.get(i), coordArr.get(i+1)); 
			}
			
			System.out.println(area);
			sc.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
