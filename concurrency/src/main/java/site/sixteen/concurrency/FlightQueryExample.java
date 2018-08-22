package site.sixteen.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class FlightQueryExample {

    private static List<String> flightCompany = Arrays.asList("CSA", "CEA", "HNA");

    public static void main(String[] args) {
        List<String> results = search("SH", "BJ");
        System.out.println("*******************result********************");
        results.forEach(System.out::println);

    }

    private static List<String> search(String origin, String destination) {
        final List<String> result = new ArrayList<>();
        List<FlightQueryTask> tasks = flightCompany.stream().map(new Function<String, FlightQueryTask>() {
            @Override
            public FlightQueryTask apply(String f) {
                return createSearchTask(f, origin, destination);
            }
        }).collect(Collectors.toList());
        tasks.forEach(Thread::start);
        tasks.forEach(new Consumer<FlightQueryTask>() {

            @Override
            public void accept(FlightQueryTask t) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        /*t-> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        tasks.stream().map(FlightQuery::get).forEach(result::addAll);
        return result;
    }

    private static FlightQueryTask createSearchTask(String flight, String origin, String destination) {
        return new FlightQueryTask(flight, origin, destination);
    }
}
