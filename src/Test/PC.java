import java.util.LinkedList;

public class PC {

    private LinkedList<Integer> list = new LinkedList<>();
    private int capacity = 2;

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (capacity == list.size()) {
                    wait();
                }
                System.out.println("Producer produced " + value);
                list.add(value++);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (list.size() == 0) {
                    wait();
                }
                int val = list.removeFirst();
                System.out.println("Consumer consumed " + val);
                notify();
                Thread.sleep(1000);
            }
        }
    }
}
