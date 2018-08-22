package site.sixteen.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class ThreadSleep {

    public static void main(String[] args) {
        new Thread(()->{
            try {
                long startTime = System.currentTimeMillis();
//                Thread.sleep(2_000L);
                // JDK1.5以后，采用TimeUnit替代Thread.sleep
                TimeUnit.SECONDS.sleep(2);
                long endTime = System.currentTimeMillis();
                System.out.println(String.format("Total spend %d ms",(endTime-startTime)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        long startTime = System.currentTimeMillis();
        sleep(3_000L);
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Main thread total spend %d ms",(endTime-startTime)));
    }

    private static void sleep(long ms){
        try {
//            Thread.sleep(ms);
            // JDK1.5以后，采用TimeUnit替代Thread.sleep
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
