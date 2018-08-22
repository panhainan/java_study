package site.sixteen.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class FlightQueryTask extends Thread implements FlightQuery {

    private final String origin;
    private final String destination;
    private final List<String> flightList = new ArrayList<>();

    public FlightQueryTask(String airline, String origin, String destination) {
        super("["+airline+"]");
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public void run() {
        System.out.printf("%s-query from %s to %s \n",getName(),origin,destination);
        int randomVal = ThreadLocalRandom.current().nextInt(10);
        try {
            TimeUnit.SECONDS.sleep(randomVal);
            this.flightList.add(getName()+"-"+randomVal);
            System.out.printf("The Flight: %s list query successful\n",getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> get() {
        return this.flightList;
    }
}
