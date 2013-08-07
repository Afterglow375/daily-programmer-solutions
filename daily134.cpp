// Daily Programmer #134 [Easy] N-Divisible Digits
// Problem: http://bit.ly/13KtpgS
 
// C++11
// Date: 8/7/13
// Description: Takes two integers, N and M, and find the largest integer composed of N-digits that is evenly divisible by M. 
// N will always be 1 or greater, with M being 2 or greater. 
// Some combinations of N and M will not have a solution.
 
///////////////////////////////////////////////////////////////////////

#include <iostream>
#include <cmath>
using namespace std;

int main()
{
	unsigned int n, m;
	cout << "Enter N and M: ";
	cin >> n >> m;

	unsigned int output = pow(10, n) - 1; // Highest possible output initialized

	int mod = output % m;
	output = output - mod;
	cout << "Answer: " << output;
	return 0;
}