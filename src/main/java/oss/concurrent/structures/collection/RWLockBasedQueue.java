package oss.concurrent.structures.collection;

import oss.concurrent.structures.exception.QueueEmptyException;
import oss.concurrent.structures.exception.QueueFullException;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Read/Write Lock based implementation of Queue
 * @param <T>
 */
public class RWLockBasedQueue<T> implements Queue<T>{

    private int head, tail;
    private T[] items;
    private ReentrantReadWriteLock lock;
    private int capacity = 10;

    public RWLockBasedQueue(){
        head = 0; tail = 0;
        lock = new ReentrantReadWriteLock();
        items = (T[])new Object[capacity];
    }

    public RWLockBasedQueue(int capacity){
        head = 0; tail = 0;
        lock = new ReentrantReadWriteLock();
        this.capacity = capacity;
        items = (T[])new Object[capacity];
    }

    public void enQ(T t) throws QueueFullException {
        lock.writeLock().lock();
        try {
            if (tail - head == items.length)
                throw new QueueFullException();
            items[tail % items.length] = t;
            tail++;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public T deQ() throws QueueEmptyException {
        lock.writeLock().lock();
        lock.readLock().lock();
        try {
            if (tail == head)
                throw new QueueEmptyException();
            T x = items[head % items.length];
            head++;
            return x;
        } finally {
            lock.writeLock().unlock();
            lock.readLock().unlock();
        }
    }

    public T peek() throws QueueEmptyException {
        lock.readLock().lock();
        try {
            if (tail == head)
                throw new QueueEmptyException();
            T x = items[head % items.length];
            head++;
            return x;
        } finally {
            lock.readLock().unlock();
        }
    }

    public T[] getItems(){
        T[] temp = (T[])new Object[tail-head];
        for(int i = head; i<tail-head;i++){
            temp[i] = items[i];
        }
        return temp;
    }
}