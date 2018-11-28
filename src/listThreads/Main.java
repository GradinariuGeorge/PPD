package listThreads;


import listThreads.listSync.SortedLinkedListSync;
import listThreads.listSync.threads.InsertThread;
import listThreads.listSync.threads.DeleteThread;
import listThreads.listSync.threads.IterateThread;
import listThreads.nodeSync.SortedLinkedList;
import listThreads.nodeSync.threads.DeleteThreadNode;
import listThreads.nodeSync.threads.InsertThreadNode;
import listThreads.nodeSync.threads.IterateThreadNode;

public class Main {

	public static void main(String[] args) {

		SortedLinkedListSync sortedLinkedListSync = new SortedLinkedListSync();
		SortedLinkedList sortedLinkedList = new SortedLinkedList();

		long secInit = System.currentTimeMillis();
////
		InsertThreadNode thread1 = new InsertThreadNode(sortedLinkedList, 1000000000);
		InsertThreadNode thread2 = new InsertThreadNode(sortedLinkedList, 50000);
		DeleteThreadNode thread3 = new DeleteThreadNode(sortedLinkedList, 5000000);
		IterateThreadNode thread4 = new IterateThreadNode(sortedLinkedList, 5);


//		InsertThread thread1 = new InsertThread(sortedLinkedListSync, 100);
//		InsertThread thread2 = new InsertThread(sortedLinkedListSync, 50);
//		DeleteThread thread3 = new DeleteThread(sortedLinkedListSync, 50);
//		IterateThread thread4 = new IterateThread(sortedLinkedListSync, 5);


		thread1.start();
		thread2.start();
		thread3.start();

		thread4.setDaemon(true);
		thread4.start();

		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}



		long secFinal = System.currentTimeMillis();

		System.out.println(secFinal-secInit);

	}

}
