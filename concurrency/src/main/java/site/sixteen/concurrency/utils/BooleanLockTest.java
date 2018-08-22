package site.sixteen.concurrency.utils;


import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class BooleanLockTest {
    private final Lock lock = new BooleanLock();
    public void syncMethod(){
        try {
            lock.lock();
            int randomInt = ThreadLocalRandom.current().nextInt(10);
            System.out.println(Thread.currentThread().getName()+" get the lock.");
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void syncMethodTimeoutable(){
        try {
            lock.lock(1000);
            System.out.println(Thread.currentThread()+" get the lock.");
            int randomInt = ThreadLocalRandom.current().nextInt(10);
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException | TimeoutException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BooleanLockTest blt = new BooleanLockTest();
        //1.多个线程通过lock()方法争抢锁
        /*IntStream.range(0,10).mapToObj(i->new Thread(blt::syncMethod)).forEach(Thread::start);*/

        //2.可中断被阻塞的线程
        /*new Thread(blt::syncMethod,"T1").start();
        TimeUnit.MILLISECONDS.sleep(100);
        Thread t2 = new Thread(blt::syncMethod,"T2");
        t2.start();
        TimeUnit.MILLISECONDS.sleep(100);
        t2.interrupt();*/

        //3.阻塞的线程可超时
        new Thread(blt::syncMethod,"T1").start();
        TimeUnit.MILLISECONDS.sleep(2);
        Thread t2 = new Thread(blt::syncMethodTimeoutable,"T2");
        t2.start();
        TimeUnit.MILLISECONDS.sleep(10);
    }
}
