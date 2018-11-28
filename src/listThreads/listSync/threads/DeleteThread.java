package listThreads.listSync.threads;


import listThreads.listSync.SortedLinkedListSync;

import java.util.Random;

public class DeleteThread extends Thread {

	private SortedLinkedListSync sortedLinkedListSync;
	private int toDelete;

	private Random rand = new Random();

	public DeleteThread(SortedLinkedListSync sortedLinkedListSync, int toDelete) {
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
