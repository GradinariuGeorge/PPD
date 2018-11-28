public class Waiter extends Thread{

    private final Message msg;

    public Waiter(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        System.out.println("Started waiter at "  + System.currentTimeMillis());
        synchronized (msg) {
            System.out.println("Waiter " + msg.getMsg() + " waiting at " + System.currentTimeMillis());
            try {
                msg.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Waiter " + msg.getMsg() + " unlocked at " + System.currentTimeMillis());
        }
    }
}
