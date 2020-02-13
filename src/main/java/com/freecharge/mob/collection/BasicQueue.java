package com.freecharge.mob.collection;

import com.freecharge.mob.exception.QueueEmptyException;
import com.freecharge.mob.exception.QueueFullException;

/**
 * Basic Queue Implementation with no concurrent locking.
 * This Implementation should be used only with use cases
 * @param <T>
 */
public class BasicQueue<T> implements Queue<T> {

    private int initialSize;
    private float loadFactor;
    private T[] items;
    volatile int head = 0, tail = 0;

    public BasicQueue(int initialSize, float loadFactor) {
        this.initialSize = initialSize;
        this.loadFactor = loadFactor;
        items = (T[])new Object[initialSize];
    }

    public BasicQueue(){
        initialSize = 10;
        loadFactor = 0.75f;
        items = (T[])new Object[initialSize];
    }


    public void enQ(T item) throws QueueFullException {
        if(tail-head== items.length){
            throw new QueueFullException();
        }
        items[tail % items.length] = item;
        tail++;
    }

    public T deQ() throws QueueEmptyException {
        if (tail - head == 0) {
            throw new QueueEmptyException();
        }
        T item = items[head % items.length];
        head++;
        return item;
    }

    public T peek() throws QueueEmptyException {
        if (tail - head == 0) {
            throw new QueueEmptyException();
        }
        return items[head % items.length];
    }
}
