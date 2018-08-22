package site.sixteen.java8;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class LambdaExpression {


    public static <T,R> List<R> map(List<T> list, Function<T,R> function){
        List<R> results = new ArrayList<>();
        for(T t:list){
            results.add(function.apply(t));
        }
        return results;
    }

    public static <T> void forEach(List<T> list, Consumer<T> consumer){
        for(T t:list){
            consumer.accept(t);
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate){
        List<T> results = new ArrayList<>();
        for(T t : list){
            if(predicate.test(t)){
                results.add(t);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList(null,"hello world!","sixteen","","  ","make money.");

        Predicate<String> isNotEmpty = (s)-> !StringUtils.isEmpty(s);
        List<String> notEmptyList = filter(listOfStrings,isNotEmpty);
        System.out.println(notEmptyList);

        List<Integer> lenResults = map(notEmptyList,s -> s.length());
        System.out.println(lenResults);

        System.out.println("**********************");
        forEach(listOfStrings,(t)-> System.out.println("'"+t+"'"));
        System.out.println("**********************");

    }
}
