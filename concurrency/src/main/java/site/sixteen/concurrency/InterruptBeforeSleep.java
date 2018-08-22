package site.sixteen.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class InterruptBeforeSleep {

    public static void main(String[] args) {
        System.out.println("main thread is interrupted ? "+Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println("main thread is interrupted ? "+Thread.currentThread().isInterrupted());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("I will be interrupted still.");
        }
    }
}
