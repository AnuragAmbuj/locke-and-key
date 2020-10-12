package com.superlocks.synchronizer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Basic barrier implementation. Just to start easy
 * explanation of barriers. This should not be used in
 * production code. This barrier itself does not entirely
 * ensure thread sync.
 */
public class BasicBarrier implements Barrier {

    private AtomicInteger count;
    private int size;

    public BasicBarrier(int size){
        count = new AtomicInteger(size);
        this.size = size;
    }

    @Override
    public void await() {
        int pos = count.getAndDecrement();
        if(pos==1){
            count.set(size);
        }else{
            while (count.get()!=0){}
        }
    }
}
