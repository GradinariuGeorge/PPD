import java.util.concurrent.Exchanger;

public class ExchangerRunnable extends Thread {
    private Exchanger exchanger = new Exchanger();
    private Object object = null;

    public ExchangerRunnable(Exchanger exchanger, Object object){
        this.exchanger = exchanger;
        this.object = object;
    }

    @Override
    public void run() {
        Object previous = this.object;
        try {
            this.object = this.exchanger.exchange(this.object);
            System.out.println(Thread.currentThread().getName() + " exchanged previous object " + previous +
                    " with " + this.object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
