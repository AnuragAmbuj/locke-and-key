package com.superlocks.structures;

public interface Semaphore {
    void acquire() throws InterruptedException;
    void release();
}
