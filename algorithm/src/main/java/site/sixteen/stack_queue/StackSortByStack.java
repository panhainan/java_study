package site.sixteen.stack_queue;

import java.util.Stack;

/**
 * StackSortByStack
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 用一个辅助栈实现另一个栈的排序
 * @date 2018/8/27
 **/
public class StackSortByStack {

    public static void stackSortByStack(Stack<Integer> dataStack) {
        Stack<Integer> assistStack = new Stack<>();
        Integer cur;
        while (!dataStack.empty()) {
            cur = dataStack.pop();
            while (!assistStack.empty() && assistStack.peek() < cur) {
                dataStack.push(assistStack.pop());
            }
            assistStack.push(cur);
        }
        while (!assistStack.empty()) {
            dataStack.push(assistStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> data = new Stack<>();
        data.push(3);
        data.push(4);
        data.push(2);
        data.push(1);
        data.push(5);
        stackSortByStack(data);
        while (!data.empty()) {
            System.out.println(data.pop());
        }
    }


}
