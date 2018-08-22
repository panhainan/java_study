package site.sixteen.stack_queue;

import java.util.Stack;

/**
 * TowStackQueue
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 两个栈实现队列
 * @date 2018/8/22
 **/
public class TowStackQueue<T> {


    /**
     * 入队栈
     */
    private Stack<T> stackIn;
    /**
     * 出队栈
     */
    private Stack<T> stackOut;
    public TowStackQueue() {
        stackIn=new Stack<>();
        stackOut = new Stack<>();
    }

    /**
     * @use 入队
     * @param t 入队元素
     */
    public void add(T t){
        stackIn.push(t);
    }

    /**
     * @use 出队
     * @return 出队元素
     */
    public T poll(){
        stackInToStackOut();
        return stackOut.pop();
    }


    /**
     * 取队头元素
     * @return 队头元素
     */
    public T peek(){
        stackInToStackOut();
        return stackOut.peek();
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean empty(){
        return stackOut.empty() && stackIn.empty();
    }

    /**
     * 获取队列大小
     * @return 队列大小
     */
    public int size(){
        return stackOut.size()+stackIn.size();
    }

    private void stackInToStackOut(){
        if(empty()){
            throw new RuntimeException("Queue is empty!");
        }else if(stackOut.empty()){
            while(!stackIn.empty()){
                stackOut.push(stackIn.pop());
            }
        }
    }
}
