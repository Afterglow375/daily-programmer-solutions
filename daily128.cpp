// Daily Programmer #128 [Easy] Sum-the-Digits, Part II
// Problem: http://bit.ly/11fMuW7
 
// C++11
// Date: 6/05/13
// Description: Sums an intger's digits continually until it's only 1 digit in length
 
///////////////////////////////////////////////////////////////////////
 
#include <iostream>
using namespace std;
 
void digitSummer() {
  unsigned int n;
	unsigned int sum;
 
	cout << "Enter an integer N to sum: ";
	cin >> sum;
 
	while (sum > 9) {
		n = sum;
		sum = 0;
		while (n > 9) {
			sum += n%10;
			n = n/10;
		}
		sum += n;
		cout << sum << endl;
	}
}
 
int main() {
	digitSummer();
  	return 0;
}