package site.sixteen.concurrency;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class TicketWindow extends Thread {
    private static int index = 1;
    private final String name;
    private final int MAX = 5000;

    public TicketWindow(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        TicketWindow t1 = new TicketWindow("1");
        t1.start();
        TicketWindow t2 = new TicketWindow("2");
        t2.start();
        TicketWindow t3 = new TicketWindow("3");
        t3.start();
        TicketWindow t4 = new TicketWindow("4");
        t4.start();
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("柜台" + name + " : 当前号码是 " + (index++));
        }
    }
}
