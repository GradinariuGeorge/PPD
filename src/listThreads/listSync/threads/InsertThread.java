package listThreads.listSync.threads;


import listThreads.listSync.SortedLinkedListSync;

import java.util.Random;

public class InsertThread extends Thread {

	private SortedLinkedListSync sortedLinkedListSync;
	private int toInsert;

	private Random rand = new Random();

	public InsertThread(SortedLinkedListSync sortedLinkedListSync, int toInsert) {
		this.sortedLinkedListSync = sortedLinkedListSync;
		this.toInsert = toInsert;
	}

	@Override
	public void run() {
		for (int i = 0; i < this.toInsert; i++) {
			sortedLinkedListSync.insert(rand.nextInt(10));
		}
	}
}
