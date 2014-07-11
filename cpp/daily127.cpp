// Daily Programmer #127 [Easy] McCarthy 91 Function
// Problem: http://bit.ly/19jJNu1
 
// C++11
// Date: 6/02/13
// Description: Writes out each step that McCarthy's function does for a given integer N.
 
///////////////////////////////////////////////////////////////////////
 
#include <iostream>
using namespace std;
 
int Mrecursion(int n) {
	if (n > 100) {
		cout << "M(" << (n-10) << ") since " << n << " is greater than 100\n";
		return n-10;
	}
	else if (n == 91) {
		cout << "91 since " << n << " is greater than 100\n";
	}
	else {
		cout << "M(M(" << (n+11) << ") since " << n << " is equal to or less than 100\n";
		return Mrecursion(Mrecursion(n+11));
	}
	return 91;
}
 
void M(int n) {
	cout << "M(" << n << ")\n";
	cout << Mrecursion(n);
}
 
int main() {
	M(99);
  	return 0;
}