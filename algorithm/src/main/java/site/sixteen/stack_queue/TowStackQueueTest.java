package site.sixteen.stack_queue;

/**
 * TowStackQueueTest
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 测试两个栈实现队列
 * @date 2018/8/23
 **/
public class TowStackQueueTest {

    public static void main(String[] args) {
        TowStackQueue<Integer> queue = new TowStackQueue<>();
        queue.add(100);
        queue.add(99);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println(queue.empty());
    }
}
