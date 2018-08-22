package site.sixteen.designpattern;

/**
 * 模板设计模式
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class TemplateMethod {

    public static void main(String[] args) {
        TemplateMethod tm = new TemplateMethod() {
        };
        tm.print("Hello Template Method!");

        TemplateMethod tm1 = new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("* " + message + " *");
            }
        };
        tm1.print("Hello Template Method!");
        TemplateMethod tm2 = new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("% " + message + " %");
            }
        };
        tm2.print("Hello Template Method!");

    }

    /**
     * 程序结构由父类控制，并且是final修饰，不允许被重写
     * 此方法等同于Thread的start方法
     * @param message
     */
    public final void print(String message) {
        System.out.println("####################");
        wrapPrint(message);
        System.out.println("####################");
    }

    /**
     * 子类只需实现想要的逻辑任务即可
     * 此方法等同于Thread的run方法
     * @param message
     */
    protected void wrapPrint(String message) {
        System.out.println(message);
    }


}
