package com.freecharge.mob.collection;

import com.freecharge.mob.exception.QueueEmptyException;
import com.freecharge.mob.exception.QueueFullException;

public interface Queue<T> {

    /**
     * Enqueuing operation
     * @param t
     * @throws QueueFullException
     */
    public void enQ(T t) throws QueueFullException;

    /**
     * Dequeue operation
     * @return
     * @throws QueueEmptyException
     */
    public T deQ() throws QueueEmptyException;

    /**
     * Returns element which is one deQ() call away from being dequeued
     * @return
     * @throws QueueEmptyException
     */
    public T peek() throws QueueEmptyException;
}
