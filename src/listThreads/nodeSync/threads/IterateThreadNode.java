package listThreads.nodeSync.threads;


import listThreads.nodeSync.Iterator;
import listThreads.nodeSync.SortedLinkedList;

import java.util.Random;

public class IterateThreadNode extends Thread {

    private SortedLinkedList sortedLinkedList;
    private int delay;

    private Random rand = new Random();

    public IterateThreadNode(SortedLinkedList sortedLinkedList, int delay) {
        this.sortedLinkedList = sortedLinkedList;
        this.delay = delay;
    }

    @Override
    public void run() {
        while (true) {
            Iterator it = sortedLinkedList.getHead();

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
