package site.sixteen.concurrency;

/**
 * 守护线程，也成为后台线程，比如JDK的垃圾回收线程
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {

        // main线程开始
        Thread thread = new Thread(()->{
            // 默认情况下（即不手动设置线程是否为守护线程），守护线程的子线程也是守护线程
            /*Thread sonThread = new Thread(()->{
                try {
                    Thread.sleep(1_000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while(true){
                    System.out.println("......");
                }
            });
            sonThread.setName("thead子线程");
            sonThread.setDaemon(false);
            sonThread.start();*/
            while(true){
                try {
                    System.out.println("...");
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 设置为守护线程
        // 若要，则必须在thread线程启动之前将其设置。
        // 若不设置，这里thread线程会一直执行，JVM进程永远不会退出。
        // 解释：在正常情况下，若JVM中没有一个非守护线程，则JVM的进程会退出
        thread.setDaemon(true);
        // 启动thread线程
        thread.start();
        Thread.sleep(2_000L);
        System.out.println("Main Thread finished lifecycle.");
        // main线程结束
    }
}
