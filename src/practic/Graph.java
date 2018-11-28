package practic;

import listThreads.nodeSync.SortedLinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Graph {
    List<Integer> nodelist = new ArrayList<>(100);
    List<Muchie> muchieList = Collections.synchronizedList(new ArrayList<>());
    int countDown = 0;

    public Graph() {
    }


    public List<Muchie> getMuchieList() {
        return muchieList;
    }

    public void setMuchieList(List<Muchie> muchieList) {
        this.muchieList = muchieList;
    }

    public synchronized Integer verificaMuchie(Integer node1, Integer node2) {
        for (Muchie muchie : muchieList) {
            if (muchie.node1 == node1 && muchie.node2 == node2)
                return muchieList.indexOf(muchie);
        }
        return null;
    }

    public synchronized void inserMuchie(Integer i1, Integer i2) throws InterruptedException {
            synchronized (this) {
                if (countDown == 5) {
                    System.out.println("Thread insert is waiting:" + Thread.currentThread().getName());
                    wait();
                }
                Integer integer=verificaMuchie(i1, i2);
                Muchie muchie=null;
                if(integer!=null)
                     muchie = muchieList.get(integer);
                if (muchie != null) {
                    muchie.weight++;
                } else {
                    Muchie muchieNew = new Muchie(i1, i2);
                    muchieList.add(muchieNew);
                }
                countDown++;
                if(countDown==5)
                    notify();
                System.out.println("Inserted muchie");
            }



    }

    public void iterate() throws InterruptedException {

            synchronized (this) {
                if (countDown < 5) {
                    System.out.println("Thread iterate is waiting:" + Thread.currentThread().getName());
                    wait();
                }
                synchronized (muchieList) {
                    Iterator i = muchieList.iterator(); // Must be in synchronized block
                    while (i.hasNext())
                        System.out.println(i.next());
                    countDown=0;

                }
                notifyAll();

            }


    }
}
