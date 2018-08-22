package site.sixteen.concurrency;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class ClassMonitor {

    public static synchronized void method1() {
        System.out.println(currentThread().getName() + " enter to method1.");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void method2() {
        System.out.println(currentThread().getName() + " enter to method1.");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void method3() {
        synchronized (ClassMonitor.class) {

            System.out.println(currentThread().getName() + " enter to method1.");
            try {
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(ClassMonitor::method1, "C1").start();
        new Thread(ClassMonitor::method2, "C2").start();
        new Thread(ClassMonitor::method3, "C3").start();
    }
}
