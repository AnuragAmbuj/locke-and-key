package com.superlocks.locks;

import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.stream.Stream;


public class BakeryLock implements Lock {

    private boolean[] flags;
    private Integer[] labels;

    public BakeryLock(int n){
        flags = new boolean[n];
        labels = new Integer[n];
        for (int i = 0; i < n; i++) {
            flags[i] = false;
            labels[i] = 0;
        }
    }

    public void lock() {
        int i = (int)Thread.currentThread().getId();
        flags[i] = true;
        labels[i] = maximum(labels) + 1;
        //TODO
        //while () {};
    }

    private Integer maximum(Integer[] labels) {
        return Stream.of(labels).max(Comparator.comparing(Integer::valueOf)).get();
    }

    public void lockInterruptibly() throws InterruptedException {
        //TODO
    }

    public boolean tryLock() {
        return false;
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public void unlock() {
        //TODO
    }

    public Condition newCondition() {
        //TODO
        return null;
    }
}
