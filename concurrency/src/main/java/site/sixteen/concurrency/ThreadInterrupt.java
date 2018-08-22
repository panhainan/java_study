package site.sixteen.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("On, I am be interrupted.");
            }
        });

        thread.start();

        TimeUnit.SECONDS.sleep(2);

        thread.interrupt();
    }
}
