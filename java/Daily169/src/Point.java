public class Point {
	public double x;
	public double y;
	public double limit;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
		this.limit = 2; // A point can only be used at most in two unique triangles
	}
	
	// Calculates the distance between this and a given point
	public double calcDistance(Point point) {
		return Math.sqrt((point.y - this.y)*(point.y - this.y) + (point.x - this.x)*(point.x - this.x));
	}
	
	// Calculates the angle made by two vectors given two points using law of cosines
	public double calcAngle(Point p1, Point p2) {
		double dist1 = this.calcDistance(p1);
		double dist2 = this.calcDistance(p2);
		double dist3 = p1.calcDistance(p2);
		return Math.toDegrees(Math.acos((dist1*dist1 + dist2*dist2 - dist3*dist3) / (2 * dist1 * dist2)));
	}
	
	// Takes two points and calculates the created triangle's area
	public double calcTriangleArea(Point p1, Point p2) {
		return Math.abs((this.x*(p1.y - p2.y) + p1.x*(p2.y - this.y) + p2.x*(this.y - p1.y))/2);
	}
}
