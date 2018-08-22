package site.sixteen.concurrency;

import java.util.Map;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class TicketWindowRunnableRevised implements Runnable {

    private int index = 1;

    private final static int MAX = 500;

    private final static Object MUTEX = new Object();


    @Override
    public void run() {
        //此处也可以将synchronized关键字用在方法run上面，但是更合理的做法是应该尽可能的将synchronized关键字只作用于共享资源（数据）的读写作用于上。
        synchronized(MUTEX){
            while(index<= MAX){
                System.out.println(Thread.currentThread().getName() + " : 当前号码是 " + (index++));
            }
        }
    }

    public static void main(String[] args) {
        final TicketWindowRunnableRevised task = new TicketWindowRunnableRevised();
        Thread t1 = new Thread(task, "1号窗口");
        Thread t2 = new Thread(task, "2号窗口");
        Thread t3 = new Thread(task, "3号窗口");
        Thread t4 = new Thread(task, "4号窗口");
        long startTime = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("总用时："+(System.currentTimeMillis()-startTime));
    }
}
