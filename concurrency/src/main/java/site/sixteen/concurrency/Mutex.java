package site.sixteen.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class Mutex {

    private final static Object MUTEXT = new Object();

    public static void main(String[] args) {
        final Mutex mutex = new Mutex();
        for (int i = 0; i < 5; i++) {
            new Thread(mutex::accessResource).start();
        }
    }

    public void accessResource() {
        synchronized (MUTEXT) {
            try {
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
