package site.sixteen.concurrency.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class BooleanLock implements Lock {

    private final List<Thread> blockedList = new ArrayList<>();
    private Thread currentThread;
    private boolean locked = false;

    @Override
    public void lock() throws InterruptedException {
        synchronized (this) {
            while (locked) {
                // 暂存当前线程，用于如果当前线程被interrupt中断，则可以从blockedList中删除
                final Thread tempThread = Thread.currentThread();
                try {
                    if (!blockedList.contains(tempThread)) {
                        blockedList.add(tempThread);
                    }
                    this.wait();
                } catch (InterruptedException e) {
                    blockedList.remove(tempThread);
                    throw e;
                }
            }
            blockedList.remove(Thread.currentThread());
            locked = true;
            currentThread = Thread.currentThread();
        }
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {
        synchronized (this) {
            if (mills <= 0) {
                this.lock();
            } else {
                long remainingMills = mills;
                long endMills = System.currentTimeMillis() + remainingMills;
                while (locked) {
                    if (remainingMills <= 0) {
                        throw new TimeoutException("can not get the lock during " + mills + " ms.");
                    }
                    final Thread tempThread = Thread.currentThread();
                    try {

                        if (!blockedList.contains(tempThread)) {
                            blockedList.add(tempThread);
                        }
                        this.wait(remainingMills);
                        remainingMills = endMills - System.currentTimeMillis();
                    } catch (InterruptedException e) {
                        blockedList.remove(tempThread);
                        throw e;
                    }
                }
                blockedList.remove(Thread.currentThread());
                locked = true;
                currentThread = Thread.currentThread();
            }
        }
    }

    @Override
    public void unlock() {
        synchronized (this) {
            if (currentThread == Thread.currentThread()) {
                this.locked = false;
                Optional.of(Thread.currentThread().getName() + " release the lock.").ifPresent(System.out::println);
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(blockedList);
    }
}
