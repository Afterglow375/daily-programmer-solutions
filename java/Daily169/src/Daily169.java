// Challenge #169 [Hard] Convex Polygon Area
// http://bit.ly/1qRrBRO

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
			// Find the two adjacent points of the anchor point
			Point anchor = coordArr.remove(0); // Arbitrarily chosen
			Point adjacentPoint1 = coordArr.remove(0);
			Point adjacentPoint2;
			int adjacentPoint2Index = 0;
			double maxAngleSoFar = 0;
			double angle = 0;
			
			
			System.out.println(anchor.x + " " + anchor.y);
			System.out.println(adjacentPoint1.x + " " + adjacentPoint1.y);
			for (int i = 0; i < coordArr.size(); i++) {
				angle = anchor.calcAngle(adjacentPoint1, coordArr.get(i));
				System.out.println(coordArr.get(i).x + " " + coordArr.get(i).y + " angle: " + angle);
				if (angle > maxAngleSoFar) {
//					System.out.println(coordArr.get(i).x + " " + coordArr.get(i).y);
					maxAngleSoFar = angle;
					adjacentPoint2Index = i;
				}
			}
			adjacentPoint2 = coordArr.remove(adjacentPoint2Index);
			System.out.println(adjacentPoint2.x + " " + adjacentPoint2.y);
			
			maxAngleSoFar = 0;
			int adjacentPoint1Index = 0;
			for (int i = 0; i < coordArr.size(); i++) {
				angle = anchor.calcAngle(adjacentPoint2, coordArr.get(i));
				if (angle > maxAngleSoFar) {
					maxAngleSoFar = angle;
					adjacentPoint1Index = i;
				}
			}
			adjacentPoint1 = coordArr.remove(adjacentPoint1Index);
			
//			System.out.println(adjacentPoint1.x + " " + adjacentPoint1.y);
//			System.out.println(adjacentPoint2.x + " " + adjacentPoint2.y);
//			System.out.println(anchor.x + " " + anchor.y);
//			
//			double area = 0;
//			while (coordArr.size() > 0) {
//				Point testingPoint = coordArr.remove(0);
//				for (int i = 0; i < coordArr.size(); i++) {
//					if (anchor.)
//				}
//				coordArr.remove(0);
//			}
//			
//			for (int i = 0; i < coordArr.size(); i++) {
//				for (int j = 0; j < coordArr.size(); j++) {
//					
//				}
//			}

//			System.out.println(area);
			sc.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
