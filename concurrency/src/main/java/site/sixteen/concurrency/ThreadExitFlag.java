package site.sixteen.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class ThreadExitFlag {

    /*
    都可以
【管理员】Alex-Wang 2018/7/18 15:03:36
双保险而已
【管理员】Alex-Wang 2018/7/18 15:04:16
另外！
【管理员】Alex-Wang 2018/7/18 15:04:27
循环体内的任务有可能很复杂
【管理员】Alex-Wang 2018/7/18 15:04:36
不能立即判断flag
     */
    static class MyTask extends Thread{
        private volatile boolean closed = false;

        @Override
        public void run() {
            System.out.println("I will start work.");
            while(!closed){// && !isInterrupted()
                System.out.println("working...");
            }
            System.out.println("I will be exiting.");
        }

        public void close(){
            this.closed = true;
//            this.interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        myTask.start();
        TimeUnit.SECONDS.sleep(10);
        System.out.println("System will be shutdown.");
        myTask.close();
    }
}
