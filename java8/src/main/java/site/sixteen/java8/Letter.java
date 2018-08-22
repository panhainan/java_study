package site.sixteen.java8;

import java.util.function.Function;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class Letter {

    public static String addHeader(String text) {
        return "From Sixteen: \n\t" + text;
    }

    public static String addFooter(String text) {
        return text + " \nKind regards";
    }

    public static String chackSpelling(String text) {
        return text.replace("labda", "lambda");
    }

    public static void main(String[] args) {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline = addHeader.andThen(Letter::chackSpelling).andThen(Letter::addFooter);
        String body = "感谢labda的帮助！";
        System.out.println(transformationPipeline.apply(body));
    }
}
