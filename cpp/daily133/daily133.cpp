// Daily Programmer #133 [Easy] Foot-Traffic Analysis
// Problem: http://bit.ly/12yQ6bg
 
// C++11
// Date: 8/9/13
// Description: Takes a formatted log file that describes the overall gallery's foot-traffic on a minute-to-minute basis. 
// Computes the average time spent in each room, and how many visitors there were in each room.
 
///////////////////////////////////////////////////////////////////////

#include <iostream>
#include <fstream>
#include <vector>
#include <array>
using namespace std;

int search(vector<array<int, 3>> &info, const int * room, const int * minutes) {
	int min = 0;
	int max = info.size()-1;
	int mid;

	if (max == -1) { // if info is empty
		array<int, 3> firstVal = {*room, *minutes, 1};
		info.push_back(firstVal);
	}
	else {
		while (max >= min) { // iterative binary search to input values in a sorted order
			mid = (min + max) / 2;
			if (*room > info[mid][0]) {
				min = mid + 1;
			}
			else if (*room < info[mid][0]) {
				max = mid - 1;
			}
			else { // key found at index mid
				info[mid][2]++; // add 1 to visitor count
				info[mid][1] += *minutes; // add mins to existing mins
				return(0);
			}
		}
		vector<array<int, 3>>::iterator iter; // No matching entry found in info if it reaches this point
		iter = info.begin();
		iter += min;
		array<int, 3> insertion = {*room, *minutes, 1}; // new room w/ minutes and 1 visitor
		info.insert(iter, insertion);
	}
	return(0);
}

int main() {
	ifstream fin ("input.txt");
 	int numLines;
	fin >> numLines;

	// declaring vars! 
	int person;
	int room;
	char status; // in or out
	int minutes;
	int actualMins;
	int allData[numLines/2][2]; // The maxsize of array needed is numLines/2 at the most, [room, minutes] in 2nd dimension
	vector<array<int, 3>> info; // Using vector for its efficient resizing and indexing, [room, avgMins, visitorCount] in 2nd dimension

	for (int i=0; i<numLines; i++) {
		fin >> person;
		fin >> room;
		fin >> status;
		fin >> minutes;
		if (status == 'I') {
			allData[person][0] = room;
			allData[person][1] = minutes;
		}
		else {
			actualMins = minutes - allData[person][1];
			search(info, &room, &actualMins); // binary search for room in info
		}
	}
	for (int i=0; i<info.size(); i++) {
		if (info[i][2] > 1) {
			info[i][1] = info[i][1] / info[i][2]; // average the minutes if visitor count is more than one
		}
    	cout << "Room " << info[i][0] << ", "
    		 << info[i][1] << " minute average visit, "
    		 << info[i][2] << " visitor(s) total" << '\n';
  	}
}