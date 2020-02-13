package com.freecharge.mob.collection;

import com.freecharge.mob.exception.QueueEmptyException;
import com.freecharge.mob.exception.QueueFullException;

import java.util.concurrent.locks.ReentrantLock;

public class LockBasedQueue<T> implements Queue<T> {
    private int head, tail;
    private T[] items;
    private ReentrantLock lock;
    private int capacity = 10;

    public LockBasedQueue() {
        head = 0;
        tail = 0;
        lock = new ReentrantLock();
        items = (T[]) new Object[capacity];
    }

    public LockBasedQueue(int capacity) {
        head = 0;
        tail = 0;
        lock = new ReentrantLock();
        this.capacity = capacity;
        items = (T[]) new Object[capacity];
    }

    public void enQ(T t) throws QueueFullException {
        lock.lock();
        try {
            if (tail - head == items.length)
                throw new QueueFullException();
            items[tail % items.length] = t;
            tail++;
        } finally {
            lock.unlock();
        }
    }

    public T deQ() throws QueueEmptyException {
        lock.unlock();
        try {
            if (tail == head)
                throw new QueueEmptyException();
            T x = items[head % items.length];
            head++;
            return x;
        } finally {
            lock.unlock();
        }
    }

    public T peek() throws QueueEmptyException {
        lock.lock();
        try {
            if (tail == head)
                throw new QueueEmptyException();
            T x = items[head % items.length];
            head++;
            return x;
        } finally {
            lock.unlock();
        }
    }
}
