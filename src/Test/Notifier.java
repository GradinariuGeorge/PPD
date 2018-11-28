public class Notifier extends Thread{
    private final Message msg;

    public Notifier(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Notifier " + name + " started at " + System.currentTimeMillis());
        try {
            sleep(1000);
            synchronized (msg) {
                msg.setMsg(name + " Notifier work done");
                msg.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
