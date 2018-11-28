package listThreads.nodeSync.threads;


import listThreads.listSync.SortedLinkedListSync;
import listThreads.nodeSync.SortedLinkedList;

import java.util.Random;

public class DeleteThreadNode extends Thread {

	private SortedLinkedList sortedLinkedListSync;
	private int toDelete;

	private Random rand = new Random();

	public DeleteThreadNode(SortedLinkedList sortedLinkedListSync, int toDelete) {
		this.sortedLinkedListSync = sortedLinkedListSync;
		this.toDelete = toDelete;
	}

	@Override
	public void run() {
		for (int i = 0; i < this.toDelete; i++) {
			sortedLinkedListSync.delete(rand.nextInt(10));
		}
	}
}
