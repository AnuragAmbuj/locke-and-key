package com.superlocks.counters;

import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Atomic Long Type Counter
 */
@Service(value = "longCounter")
public class LongCounter {
    private long value;
    private ReentrantLock lock = new ReentrantLock();

    public long incrementAndGet(){
        lock.lock();
        try{
            long temp = value;
            value = temp + 1;
        }finally {
            lock.unlock();
        }
        return value;
    }

    public long incrementAndGet(long value){
        lock.lock();
        try{
            long temp = this.value;
            this.value = temp + value;
        }finally {
            lock.unlock();
        }
        return this.value;
    }

    public long incrementAndGet(int value){
        lock.lock();
        try{
            long temp = this.value;
            this.value = temp + value;
        }finally {
            lock.unlock();
        }
        return this.value;
    }
}
