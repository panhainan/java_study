package site.sixteen.concurrency.utils;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public interface Lock {

    /**
     * 与关键字synchronized类似，除非获取到了锁，否则线程A.lock()方法永远阻塞线程A
     * 但是该方法与synchronized不同的是，该方法可以被中断
     *
     * @throws InterruptedException 中断异常
     */
    void lock() throws InterruptedException;

    /**
     * 与lock()类似，指定mills毫秒时间内阻塞，同时增加了对应的超时功能
     *
     * @param mills 毫秒(小于等于0的情况会默认调用lock()方法)
     * @throws InterruptedException 中断异常
     * @throws TimeoutException 超时异常
     */
    void lock(long mills) throws InterruptedException, TimeoutException;

    /**
     * 释放锁
     */
    void unlock();

    /**
     * @return 当前被阻塞的线程
     */
    List<Thread> getBlockedThreads();


}
