import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class AfisareMesaj implements Callable {

    private String msg;

    public AfisareMesaj(String msg) {
        this.msg = msg;
    }

    @Override
    public Object call() throws Exception {
        sleep(10000);
        System.out.println("thread print: " + msg);
        return Thread.currentThread().getName() + " " + msg;
    }
}
