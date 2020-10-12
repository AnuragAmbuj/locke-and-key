package com.superlocks.counters;

import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReentrantLock;

@Service(value = "intCounter")
public class IntCounter {
    private int value;
    private ReentrantLock lock = new ReentrantLock();

    public int incrementAndGet(){
        lock.lock();
        try{
            int temp = value;
            value = temp + 1;
        }finally {
            lock.unlock();
        }
        return value;
    }

    public int incrementAndGet(int value){
        lock.lock();
        try{
            int temp = this.value;
            this.value = temp + value;
        }finally {
            lock.unlock();
        }
        return value;
    }
}
