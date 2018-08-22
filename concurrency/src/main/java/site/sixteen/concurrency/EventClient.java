package site.sixteen.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class EventClient {

    public static void main(String[] args){
        final EventQueue eventQueue = new EventQueue();
        new Thread(()->{
            for(;;){
                eventQueue.offer(new EventQueue.Event());
            }
        },"Producer-1").start();
        new Thread(()->{
            for(;;){
                eventQueue.offer(new EventQueue.Event());
            }
        },"Producer-2").start();
        new Thread(()->{
            for(;;){
                eventQueue.take();
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Consumer-1").start();
        new Thread(()->{
            for(;;){
                eventQueue.take();
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Consumer-2").start();
    }
}
