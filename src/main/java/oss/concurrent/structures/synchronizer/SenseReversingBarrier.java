package oss.concurrent.structures.synchronizer;

import java.util.concurrent.atomic.AtomicInteger;

public class SenseReversingBarrier implements Barrier{

    private boolean sense;
    private AtomicInteger count;
    private int size;
    private ThreadLocal<Boolean> threadSense;

    public SenseReversingBarrier(int n){
        this.size = n;
        count = new AtomicInteger(n);
        sense = false;
        threadSense = ThreadLocal.withInitial(() -> !sense);
    }

    @Override
    public void await() {
        boolean revSense = threadSense.get();
        int pos = count.getAndDecrement();
        if(pos == 1){
            count.set(size);
            sense = revSense;
        }else{
            while (sense!=revSense) {}
        }
        threadSense.set(!revSense);
    }
}
