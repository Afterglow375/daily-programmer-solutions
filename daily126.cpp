// Daily Programmer #126 [Intermediate] Perfect P'th Powers
// Problem: http://bit.ly/1369E5i
 
// C++11
// Date: 6/8/13
// Description: An integer X is a "perfect p'th power" if there is some integer Y such that Y^P = X.
// Finds the highest value of P for a given X.
 
///////////////////////////////////////////////////////////////////////
 
#include <iostream>
#include <cmath>
using namespace std;
 
void pthPower() {
  cout << "Enter an X: ";
	unsigned int x;
	cin >> x;
 
	unsigned int p;
	p = (ceil(log10(x))*3)+2; // messed around with my calculator to find that 2^p with this initial p tends to be close to X
	
	// Initial y^p has to be >= x for this while loop to work properly
	unsigned int y = 2; // y starts at two to allow the highest possible p
	while (pow(y, p) != x) {
		if (pow(y, p) > x) {
			p--;
			if (p == 1) {
				y = x;
				break;
			}
		}
		if (pow(y, p) < x) {
			y++;
		}
	}
	cout << p << " (" << y << "^" << p << ")";
}
 
int main() {
	pthPower();
  	return 0;
}