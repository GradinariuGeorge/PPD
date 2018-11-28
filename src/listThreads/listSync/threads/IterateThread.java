package listThreads.listSync.threads;


import listThreads.listSync.Iterator;
import listThreads.listSync.SortedLinkedListSync;

import java.util.Random;

public class IterateThread extends Thread {

	private SortedLinkedListSync sortedLinkedListSync;
	private int delay;

	private Random rand = new Random();

	public IterateThread(SortedLinkedListSync sortedLinkedListSync, int delay) {
		this.sortedLinkedListSync = sortedLinkedListSync;
		this.delay = delay;
	}

	@Override
	public void run() {
		while(true) {
			Iterator it = sortedLinkedListSync.getHead();

			while (it.isValid()) {
				System.out.print(it.getValue() + " ");
				it.next();
			}

			System.out.println("");
			try {
				Thread.sleep(this.delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
