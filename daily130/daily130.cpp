// Daily Programmer #130 [Intermediate] Foot-Traffic Generator
// Problem: http://bit.ly/1bosV8j
 
// C++11
// Date: 8/10/13
// Description: Generates test input files for daily #133's challenge.

// Var description:
// E (for the number of events to generate), 
// V (for the number of visitors), 
// R (for the number of rooms), 
// I (for the time at which the earliest event can occur), 
// and O (for the time at which the last event can occur)
 
///////////////////////////////////////////////////////////////////////

#include <iostream>
#include <fstream>
#include <random>
using namespace std;

int main() {
	ifstream fin ("input.txt");
	int E, V, R, I, O; // events, visitors, room, earliest possible min, latest possible min 
	fin >> E >> V >> R >> I >> O; // 18 8 32 300 550

	// Random seed initializer
	random_device rd;
	default_random_engine generator(rd()); // Uniformly distributed random numbers

	int repititions = (E / (V+1));
	if ((E % (V+1)) != 0)
		repititions++;
	int minuteScale = ((O-I) / repititions);
	int upperMinute = minuteScale + I;
	int lowerMinute = I;
	int count = 0;
	// int count2 = 0; count2 for debugging purposes
	pair<int, int> minsAndRooms[V+1]; // (Minute and room)

	cout << E*2 << '\n'; // Print the # of lines first
	while (lowerMinute < O) {
		count++;
		if (count == repititions) {
			V = (E - ((count-1)*(V+1))) - 1;
			upperMinute = O;
		}

		for (unsigned i = 0; i <= V; i++) {
			uniform_int_distribution<int> randomLowerMinute(lowerMinute, upperMinute-1);
			uniform_int_distribution<int> randomRoom(0, R);
			minsAndRooms[i].first = randomLowerMinute(generator);
			minsAndRooms[i].second = randomRoom(generator);
			cout << i << ' ' << minsAndRooms[i].second << ' ' << 'I' << ' ' << minsAndRooms[i].first << '\n';
			// count2++;
			// cout << count2 << endl;
		}

		for (unsigned i = 0; i <= V; i++) {
			uniform_int_distribution<int> randomUpperMinute((minsAndRooms[i].first)+1, upperMinute);
			cout << i << ' ' << minsAndRooms[i].second << ' ' << 'O' << ' ' << randomUpperMinute(generator) << '\n';
			// count2++;
			// cout << count2 << endl;
		}

		lowerMinute = upperMinute+1;
		upperMinute += minuteScale;
	}
	
	fin.close();
	return 0;
}