// Daily Programmer #146 [Easy] Polygon Perimeter
// Problem: http://bit.ly/1cnu1vY
 
// C++11
// Date: 1/1/14
// Description: Input will consist of one line on standard console input. 
// This line will contain first an integer N, then a floating-point number R.
// They will be space-delimited.
// The integer N is for the number of sides of a regular polygon, which is between 3 to 100, inclusive. 
// R will be the circumradius, which ranges from 0.01 to 100.0, inclusive.
// Output: Print the permitter of the given N-sided polygon that has a circumradius of R. 
// Print up to three digits precision.
 
///////////////////////////////////////////////////////////////////////

// circumradius = sideLength / 2*sin(pi/numSides)
// sideLength = circumradius * (2*sin(pi/numSides)) 

#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;

void computePerimeter() {
	cout << "Enter input: ";

	unsigned int numSides;
	double circumradius;
	const double PI = 3.141592653589793;

	cin >> numSides >> circumradius;

	double sideLength = circumradius * (2*sin(PI/numSides)); // Formula for side length of a regular polygon
	
	cout << fixed;
	cout << setprecision(3);
	cout << "The perimeter is " << sideLength*numSides;
}

int main() {
	computePerimeter();
}