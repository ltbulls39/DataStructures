#include <iostream>
#include "LinkedList.h"

LinkedList::LinkedList() {
	head = nullptr;
}

LinkedList::~LinkedList() {

}

void LinkedList::addToFront(int data) {
	Node *newNode = new Node;

	newNode->data = data;
	newNode->next = head;
	head = newNode;

}

void LinkedList::addToEnd(int data) {
	
	if (head == nullptr) {
		addToFront(data);
		return;
	}
	Node *newNode = new Node;
	newNode->data = data;

	Node* temp = head;

	while (temp->next != nullptr) {
		temp = temp->next;
	}

	temp->next = newNode;

}

void LinkedList::addOrganized(int data) {
	if (head == nullptr || head->data > data) {
		addToFront(data);
		return;
	}

	Node *temp = head;
	while (temp->next != nullptr) {
		if (temp->next->data > data)
			break;
		temp = temp->next;
	}

	Node *newNode = new Node;
	newNode->data = data;
	newNode->next = temp->next;
	temp->next = newNode;
}

bool LinkedList::removeFirstInstance(int data) {
	if (head == nullptr)
		return false;

	if (head->data == data) {
		Node *target = head;
		head = head->next;
		delete target;
		return true;
	}

	Node *temp = head;
	while (temp->next != nullptr) {
		if (temp->next->data == data)
			break;
		temp = temp->next;
	}

	if (temp->next != nullptr && temp->next->data == data) {
		Node *target = temp->next;
		temp->next = target->next;

		delete target;
		return true;
	}

	return false;
	


}

bool LinkedList::contains(int data) {
	//empty list
	if (head == nullptr)
		return false;
	
	Node *temp = head;
	while (temp != nullptr) {
		//if we find the data
		if (temp->data == data)
			return true;
		temp = temp->next;
	}
	//we haven't found it
	return false;
}

void LinkedList::print() {
	Node *temp = head;

	while (temp != nullptr) {
		std::cout << temp->data << std::endl;
		temp = temp->next;
	}
}
