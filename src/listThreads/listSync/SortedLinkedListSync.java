package listThreads.listSync;


import listThreads.Logger;

public class SortedLinkedListSync {

	Node<Double> head;

	public synchronized void insert(double newNumber) {
		Logger.log("Thread " + Thread.currentThread().getName() + " inserting " + newNumber );
		Node newNode = new Node(newNumber);
		if (head == null) {
			head = newNode;
			return;
		}
		Node<Double> firstNode = head;

		if (firstNode.getValue() > newNumber) {
			newNode.setNext(this.head);
			this.head = newNode;
			return;
		}

		while (firstNode.hasNext()) {
			if (firstNode.getNext().getValue() > newNumber) {
				newNode.setNext(firstNode.getNext());
				firstNode.setNext(newNode);
				return;
			}
			firstNode = firstNode.getNext();
		}

		firstNode.setNext(newNode);


	}

	public synchronized void delete(double toDelete) {

		Logger.log("Thread " + Thread.currentThread().getName() + " deleting " + toDelete);

		if (head == null) {
			return;
		}
		if(head.getValue() == toDelete){
			head=null;
			return;
		}
		Node<Double> firstNode = head;
		while (firstNode.hasNext()) {
			if (firstNode.getNext().getValue() == toDelete) {
				firstNode.setNext(firstNode.getNext().getNext());
			}
			if (firstNode.hasNext()) {
				firstNode = firstNode.getNext();
			}
		}
	}

	public synchronized Iterator getHead() {

		Logger.log("Thread " + Thread.currentThread().getName() + " getting iterator ");

		return new Iterator(head);
	}


}
