package com.freecharge.mob.collection;


import com.freecharge.mob.exception.QueueEmptyException;
import com.freecharge.mob.exception.QueueFullException;
import org.junit.Before;
import org.junit.Test;

class RWLockBasedQueueTest {

    private RWLockBasedQueue<String> rwLockBasedQueue;

    @Before
    public void init(){
        rwLockBasedQueue = new RWLockBasedQueue<>();
    }

    @Test(expected = QueueEmptyException.class)
    void enQ() throws QueueFullException, QueueEmptyException {
        rwLockBasedQueue = new RWLockBasedQueue<>();
        rwLockBasedQueue.enQ("Abcidic");
        rwLockBasedQueue.enQ("Volic");
        rwLockBasedQueue.enQ("GGGGGG");
        System.out.println(rwLockBasedQueue.peek());
        rwLockBasedQueue.deQ();
        System.out.println(rwLockBasedQueue.peek());
        rwLockBasedQueue.deQ();
        System.out.println(rwLockBasedQueue.peek());
        rwLockBasedQueue.deQ();
        System.out.println(rwLockBasedQueue.peek());
        rwLockBasedQueue.deQ();
    }

    @Test
    void deQ() {
    }

    @Test
    void peek() {
    }
}