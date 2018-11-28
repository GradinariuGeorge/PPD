package listThreads.nodeSync;


import listThreads.Logger;

public class SortedLinkedList {

    NodeSync<Double> head;

    public void insert(double newNumber) {
        Logger.log("Thread " + Thread.currentThread().getName() + " inserting " + newNumber);
        NodeSync newNode = new NodeSync<>(newNumber);
        if (head == null) {
            head = newNode;
            return;
        }
        NodeSync<Double> firstNode = head;

        if (firstNode.getValue() > newNumber) {
            synchronized (firstNode) {
                synchronized (head) {
                    newNode.setNext(this.head);
                    this.head = newNode;
                }
            }
            return;
        }

        while (firstNode.hasNext()) {
            if (firstNode.getNext().getValue() > newNumber) {
                synchronized (firstNode) {
                    synchronized (firstNode.getNext()) {
                        newNode.setNext(firstNode.getNext());
                        firstNode.setNext(newNode);
                    }
                }
                return;
            }
            firstNode = firstNode.getNext();
        }
        synchronized (firstNode) {
            firstNode.setNext(newNode);
        }

    }

    public void delete(double toDelete) {

        Logger.log("Thread " + Thread.currentThread().getName() + " deleting " + toDelete);

        if (head == null) {
            return;
        }

        NodeSync<Double> firstNode = head;
        synchronized (firstNode) {
            while (firstNode.hasNext()) {
                synchronized (firstNode.getNext()) {
                    if (firstNode.getNext().getValue() == toDelete) {
                        if (firstNode.getNext().getNext() != null) {
                            synchronized (firstNode.getNext().getNext()) {
                                firstNode.setNext(firstNode.getNext().getNext());
                            }
                        } else {
                            firstNode.setNext(firstNode.getNext().getNext());
                        }
                    }
                }
                if (firstNode.hasNext()) {
                    firstNode = firstNode.getNext();
                }
            }
        }


    }

    public synchronized Iterator getHead() {

        Logger.log("Thread " + Thread.currentThread().getName() + " getting iterator ");

        return new Iterator(head);
    }
}
