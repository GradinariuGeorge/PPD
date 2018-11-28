package MulthitreahdingTest;

public class Consumer extends Thread {
    private CubbyHole cubbyhole;
    private String number; //id

    public Consumer(CubbyHole c, String number) {
        cubbyhole = c;
        this.number = number;
    }

    public void run() {
        int value = 0;
        for (int i = 0; i < number.length(); i++) {
            number += cubbyhole.get();
            System.out.println("Get "+i);
        }
    }
}
