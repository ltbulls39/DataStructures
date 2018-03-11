#pragma once
#include "Node.h"

class LinkedList {
private:
	Node *head;
	void addToFront(int data);	//check
	void addToEnd(int data);	//check
public:
	LinkedList();
	~LinkedList();
	void addOrganized(int data);
	bool removeFirstInstance(int data);
	bool contains(int data);
	void print();
};