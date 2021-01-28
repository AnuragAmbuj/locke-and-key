package oss.concurrent.structures.structures;

public interface Semaphore {
    void acquire() throws InterruptedException;
    void release();
}
