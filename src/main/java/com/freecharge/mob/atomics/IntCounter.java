package com.freecharge.mob.atomics;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IntCounter {
    private int value;
    private ReentrantLock lock = new ReentrantLock();

    public int getAndIncrement(){
        lock.lock();
        try{
            int temp = value;
            value = temp + 1;
        }finally {
            lock.unlock();
        }
        return value;
    }
}
