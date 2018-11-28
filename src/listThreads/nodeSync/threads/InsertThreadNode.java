package listThreads.nodeSync.threads;


import listThreads.nodeSync.SortedLinkedList;

import java.util.Random;

public class InsertThreadNode extends Thread {

	private SortedLinkedList sortedLinkedList;
	private int toInsert;

	private Random rand = new Random();

	public InsertThreadNode(SortedLinkedList sortedLinkedList, int toInsert) {
		this.sortedLinkedList = sortedLinkedList;
		this.toInsert = toInsert;
	}

	@Override
	public void run() {
		for (int i = 0; i < this.toInsert; i++) {
			sortedLinkedList.insert(rand.nextInt(10));
		}
	}
}
