package site.sixteen.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FilterApple
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 筛选苹果
 * @date 2018/10/8
 */
public class FilterApple {
    public static List<Apple> findGreenApple(List<Apple> appleList) {
        List<Apple> greenAppleList = new ArrayList<>();
        for (Apple apple : appleList) {
            if ("green".equals(apple.getColor())) {
                greenAppleList.add(apple);
            }
        }
        return greenAppleList;
    }

    public static List<Apple> findApple(List<Apple> appleList,String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : appleList) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green", 150), new Apple("yellow", 100), new Apple("green", 110), new Apple("red", 160));
        /*
        List<Apple> greenAppleList = findGreenApple(list);
        assert greenAppleList.size() == 2;
        System.out.println(greenAppleList);

        List<Apple> redAppList = findApple(list,"red");
        assert redAppList.size() == 1;
        System.out.println(redAppList);

        List<Apple> result =findApple(list,new GreenAnd150WeighFilter());
        System.out.println(result);

        List<Apple> result1 =findApple(list,new AppleFilter(){

            @Override
            public boolean filter(Apple apple) {
                return "green".equals(apple.getColor()) && apple.getWeight() >= 150;
            }
        });
        System.out.println(result1);
        */

        /*
        List<Apple> result2 = findAppleByLambda(list,(Apple apple)->{
            return "green".equals(apple.getColor()) && apple.getWeight() >= 150;
        });
        */
        List<Apple> result2 = findAppleByLambda(list,apple->"green".equals(apple.getColor()) && apple.getWeight() >= 150);
        System.out.println(result2);

    }

    @FunctionalInterface
    public interface AppleFunctionInterface{
        boolean filter(Apple apple);
    }

    public static List<Apple> findAppleByLambda(List<Apple> appleList, AppleFunctionInterface appleFunctionInterface) {

        List<Apple> list = new ArrayList<>();
        for(Apple apple:appleList){
            if(appleFunctionInterface.filter(apple)){
                list.add(apple);
            }
        }
        return list;
    }


    /**
     * 策略模式
     */
    public interface AppleFilter{
        boolean filter(Apple apple);
    }

    public static List<Apple> findApple(List<Apple> appleList,AppleFilter appleFilter) {

        List<Apple> list = new ArrayList<>();
        for(Apple apple:appleList){
            if(appleFilter.filter(apple)){
                list.add(apple);
            }
        }
        return list;
    }

    public static class GreenAnd150WeighFilter implements AppleFilter{

        @Override
        public boolean filter(Apple apple) {
            return "green".equals(apple.getColor()) && apple.getWeight() >= 150;
        }
    }
}
