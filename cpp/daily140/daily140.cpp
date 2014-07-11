// Daily Programmer #140 [Intermediate] Adjacency Matrix
// Problem: http://bit.ly/1g8OEjZ
 
// C++11
// Date: 8/7/13
// Description: Takes in a list of edge-node relationships, and print a directed adjacency matrix for it.
// Given a line with two space-delimited integers N and M. 
// N is the number of nodes / vertices in the graph
// M is the number of following lines of edge-node data. 
// A line of edge-node data is a space-delimited set of integers, with the special "->" symbol indicating an edge. 
// This symbol shows the edge-relationship between the set of left-sided integers and the right-sided integers. 
// This symbol will only have one element to its left, or one element to its right. 
// These lines of data will also never have duplicate information; do not have to handle re-definitions of the same edges.
 
///////////////////////////////////////////////////////////////////////

#include <iostream>
#include <fstream>
#include <vector>
#include <sstream>
#include <iterator>
#include <string>
using namespace std;

// Splits lines into tokens
void split(const string &s, char delim, vector<string> &elems) {
    stringstream ss(s);
    string item;
    while (getline(ss, item, delim)) {
        elems.push_back(item);
    }
}

// Outputs final adjacency matrix
void printAdjacencyMatrix(int adjacencyMatrix[], int numNodes) {
	for (unsigned int line = 0; line < numNodes; line++) {
		for (unsigned int node = 0; node < numNodes; node++) {
			cout << adjacencyMatrix[line*numNodes + node];
		}
		cout << '\n';
	}
}

int main() {
	ifstream fin ("input.txt");
	unsigned int numNodes, numLines;
	
	fin >> numNodes >> numLines;
	fin.ignore(2, ' '); // Read past newline
	int *adjacencyMatrix = new int[numNodes*numNodes](); // Create adjacency matrix of all zeros

	int nodeNumber;
	string line;
	for (unsigned int i = 0; i < numLines; i++) { // For each line
		getline(fin, line);
		vector<string> tokens;
		split(line, ' ', tokens);
		vector<string>::iterator nodePtr = tokens.begin();
		vector<int> connectingNodes;

		while (*nodePtr != "->") { // Get the connecting nodes
			stringstream ss(*nodePtr);
			ss >> nodeNumber;
			connectingNodes.push_back(nodeNumber);
			nodePtr++;
		}
		nodePtr++; // Advance past the "->" 
		while (nodePtr != tokens.end()) { // Get the connected nodes
			stringstream ss(*nodePtr);
			ss >> nodeNumber;
			for (vector<int>::iterator oldNodePtr = connectingNodes.begin(); oldNodePtr != connectingNodes.end(); ++oldNodePtr) {
				adjacencyMatrix[*oldNodePtr*numNodes + nodeNumber] = 1; // Set the appropriate index in the adjacency matrix to 1
			}
			nodePtr++;
		}
	}

	printAdjacencyMatrix(adjacencyMatrix, numNodes);
	delete [] adjacencyMatrix;
}