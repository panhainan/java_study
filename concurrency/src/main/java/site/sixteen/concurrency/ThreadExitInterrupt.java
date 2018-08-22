package site.sixteen.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class ThreadExitInterrupt {

    public static void main(String[] args) throws InterruptedException {
        /*Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("I will start work.");
                System.out.println(isInterrupted());
                while(!isInterrupted()){
                    //working
                    System.out.println("working...");
                }
            }
        };
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("System will be shutdown.");
        thread.interrupt();
        System.out.println("1."+thread.isInterrupted());
        System.out.println("2."+thread.isInterrupted());
        System.out.println("3."+thread.isInterrupted());
        TimeUnit.SECONDS.sleep(1);
        System.out.println("4."+thread.isInterrupted());*/
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("I will start work.");
                while(true){
                    if(isInterrupted()){
                        System.out.println("Interrupted!");
                        break;
                    }
                    //working
                    System.out.println("working...");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println( "Interrupted when sleep!");
                        System.out.println("isInterrupted:"+isInterrupted());
                        interrupt();
                        System.out.println("isInterrupted:"+isInterrupted());
                    }
                }
            }
        };
        thread.start();
        TimeUnit.SECONDS.sleep(5);
        thread.interrupt();
    }

}
