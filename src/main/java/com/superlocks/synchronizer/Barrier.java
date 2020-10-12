package com.superlocks.synchronizer;

/**
 * Barriers are a technique to enforce synchronization in asynchronous tasks/threads.
 * Barriers are a way to force asynchronous threads to act as if they were synchronous
 * Page 397: ArtOfMultiprocessorProgramming
 */
public interface Barrier {
    public void await();
}
