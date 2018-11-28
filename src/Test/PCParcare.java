import java.util.LinkedList;
import java.util.List;

public class PCParcare {
    private LinkedList<Integer> list = new LinkedList<>();
    private int capacity;
    private List<String> messages;

    public PCParcare(int capacity, int n, List<String> messages) {
        this.capacity = capacity;
        for(int i= 0; i < n; i++) {
            this.list.add(i);
        }
        this.messages = messages;
    }

    public void produce() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (capacity == list.size()) {
                    wait();
                }
//                synchronized (messages) {
//                    String message = "Intrare masina. Capacitate: " + list.size();
//                    messages.add(message);
//                }
                list.add(69);
                System.out.println("Intrare masina. Capacitate: " + list.size());
                notifyAll();
                Thread.sleep(100);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (list.size() == 0) {
                    wait();
                }
                list.removeFirst();
//                synchronized (messages) {
//                    String message = "Iesire masina. Capacitate: " + list.size();
//                    messages.add(message);
//                }

                System.out.println("Iesire masina. Capacitate: " + list.size());
                notifyAll();
                Thread.sleep(100);
            }
        }
    }


    public void printCapacity() {
        int size = 0;
        synchronized (this.list) {
            for(int i = 0 ; i < this.list.size() ; i++ ) {
                size++;
            }
            System.out.println("Capacity: " + (capacity - size));
        }
    }
}
