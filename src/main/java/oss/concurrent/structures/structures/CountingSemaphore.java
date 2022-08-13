package oss.concurrent.structures.structures;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Counting Semaphore Implementation in Java
 * @Author Anurag Ambuj
 */
public class CountingSemaphore implements Semaphore {

    private int capacity;
    private int state;
    private Lock lock;
    private Condition condition;

    public CountingSemaphore(){
        this.capacity = 10;
        state = 0;
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public CountingSemaphore(int capacity){
        this.capacity = capacity;
        state = 0;
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    @Override
    public void acquire() throws InterruptedException {
        lock.lock();
        try{
            while(state == capacity)
                condition.await();
            state++;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void release() {
        lock.lock();
        try{
            state--;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
