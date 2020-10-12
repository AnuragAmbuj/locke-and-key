package com.superlocks.structures;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Binary Semaphore Implementation in Java!
 * @Author Anurag Ambuj
 */
public class BinarySemaphore implements Semaphore {

    private int capacity;
    private Lock lock;
    private Condition condition;
    private short[] permits;

    public BinarySemaphore(){
        this.capacity = 10;
        this.permits = new short[capacity];
        this.lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public BinarySemaphore(int capacity){
        this.capacity = capacity;
        this.permits = new short[capacity];
        this.lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    @Override
    public void acquire() throws InterruptedException {
        lock.lock();
        final int index = getFirstEmptyPermitIndex();
        try{
            while(index==-1)
                condition.await();
            permits[index] = 1;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void release() {
        lock.lock();
        final int index = getFirstFilledPermitIndex();
        try{
            permits[index] = 0;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    private int getFirstEmptyPermitIndex(){
        for(int i=0;i<capacity;i++){
            if(permits[i]==0)
                return i;
        }
        return -1;
    }

    private int getFirstFilledPermitIndex(){
        for(int i=0;i<capacity;i++){
            if(permits[i]==1)
                return i;
        }
        return -1;
    }
}
