package MulthitreahdingTest;

public class Producer extends Thread {
    private CubbyHole cubbyhole;
    private int number; //id

    public Producer(CubbyHole c, int number) { cubbyhole = c;
        this.number = number;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            cubbyhole.put(i);
            System.out.println("Put "+ i);
            try {
                sleep((int) (Math.random() * 100));
            } catch (
                    InterruptedException e) {
            }
        }
    }
}
