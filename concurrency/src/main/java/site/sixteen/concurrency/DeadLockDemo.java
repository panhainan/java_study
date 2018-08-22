package site.sixteen.concurrency;

import static java.lang.Thread.currentThread;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class DeadLockDemo {

    private final Object MUTEX_READ = new Object();
    private final Object MUTEX_WRITE = new Object();

    public static void main(String[] args) {
        final DeadLockDemo deadLockDemo = new DeadLockDemo();
        new Thread(() -> {
            while (true) {
                deadLockDemo.read();
            }
        }, "READ-THREAD").start();
        new Thread(() -> {
            while (true) {
                deadLockDemo.write();
            }
        }, "WRITE-THREAD").start();
    }

    public void read() {
        synchronized (MUTEX_READ) {
            System.out.println(currentThread().getName() + " get READ lock.");

            synchronized (MUTEX_WRITE) {
                System.out.println(currentThread().getName() + " get WRITE lock.");
            }
            System.out.println(currentThread().getName() + " release WRITE lock.");
        }
        System.out.println(currentThread().getName() + " release READ lock.");
    }

    public void write() {
        synchronized (MUTEX_WRITE) {
            System.out.println(currentThread().getName() + " get WRITE lock.");

            synchronized (MUTEX_READ) {
                System.out.println(currentThread().getName() + " get READ lock.");
            }
            System.out.println(currentThread().getName() + " release READ lock.");
        }
        System.out.println(currentThread().getName() + " release WRITE lock.");
    }
}
