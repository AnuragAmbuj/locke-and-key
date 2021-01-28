package oss.concurrent.structures.synchronizer;

public interface Latch {
    void await() throws InterruptedException;
}
