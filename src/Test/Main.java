import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int nrThreads = 3;
        List<String> messages = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);
        System.out.println("introduceti nr de parcari: ");
        int p = scanner.nextInt();
        System.out.println("Introduceti nr de locuri ocupate");
        int n = scanner.nextInt();

        PCParcare pc = new PCParcare(p, n, messages);

        for(int i = 0; i < nrThreads; i++) {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        pc.produce();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        pc.consume();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t1.start();
            t2.start();
        }

        Thread iterate = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pc.printCapacity();
                }
            }
        });

        iterate.start();
    }
}
