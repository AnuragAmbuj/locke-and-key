package oss.concurrent.structures.basic;

public class ThreadID {
    private ThreadID(){}
    public static long get(){
        return Thread.currentThread().getId();
    }
}
