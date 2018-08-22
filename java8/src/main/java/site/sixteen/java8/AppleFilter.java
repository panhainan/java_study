package site.sixteen.java8;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class AppleFilter {


    public static void main(String[] args) {
        List<Apple> appleList = Arrays.asList(new Apple("red", 166), new Apple("green", 100), new Apple("red", 120), new Apple("red", 150), new Apple("green", 80));


        // 1. 传递代码
        /*appleList.sort(new AppleComparator());*/
        // 2.使用匿名类
        /*appleList.sort(new Comparator<Apple>(){
            @Override
            public int compare(Apple a1,Apple a2){
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });*/
        // 3.使用Lambda表达式
        /*appleList.sort((a1,a2)->a1.getWeight().compareTo(a2.getWeight()));*/
        /*appleList.sort(comparing((a)->a.getWeight()));*/
        // 4.使用方法引用
        appleList.sort(comparing(Apple::getWeight));
        System.out.println(appleList);
        appleList.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
        System.out.println("逆序："+appleList);
    }
}
