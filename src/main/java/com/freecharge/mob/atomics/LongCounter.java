package com.freecharge.mob.atomics;

import java.util.concurrent.locks.ReentrantLock;

public class LongCounter {
    private long value;
    private ReentrantLock lock = new ReentrantLock();

    public long getAndIncrement(){
        lock.lock();
        try{
            long temp = value;
            value = temp + 1;
        }finally {
            lock.unlock();
        }
        return value;
    }
}
