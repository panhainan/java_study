package site.sixteen.concurrency;

import static java.lang.Thread.sleep;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class TicketWindowRunnable implements Runnable {

    private final int MAX = 500;
    private int index = 1;

    public static void main(String[] args) {
        final TicketWindowRunnable task = new TicketWindowRunnable();
        Thread t1 = new Thread(task, "1号窗口");
        Thread t2 = new Thread(task, "2号窗口");
        Thread t3 = new Thread(task, "3号窗口");
        Thread t4 = new Thread(task, "4号窗口");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread().getName() + " : 当前号码是 " + index++);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    存在问题：
    1.重复号码
        4号窗口 : 当前号码是 10
        1号窗口 : 当前号码是 10
        3号窗口 : 当前号码是 10
        2号窗口 : 当前号码是 11
        3号窗口 : 当前号码是 12
        1号窗口 : 当前号码是 13
     2.略过号码
     3.超出最大值
     */
}
