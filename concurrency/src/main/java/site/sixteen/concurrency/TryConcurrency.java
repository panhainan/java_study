package site.sixteen.concurrency;


import java.util.concurrent.TimeUnit;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class TryConcurrency {

    public static void main(String[] args){
        new Thread(){
            @Override
            public void run() {
                browseNews();
            }
        }.start();
        enjoyMusic();
    }

    private static void enjoyMusic() {
        for (;;){
            System.out.println("Uh-huh, the nice music.");
            sleep(1);
        }
    }

    private static void browseNews() {
        for (;;){
            System.out.println("Uh-huh, the good news.");
            sleep(1);
        }
    }

    private static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
