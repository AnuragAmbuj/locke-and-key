package oss.concurrent.structures.types;

/**
 * StampedValue Class, implemented according to an example
 * in Herlihy's and Shavit's "The Art of Multiprocessor
 * programming", allows an epoch timestamp and a value
 * to be written and read together.
 * This makes it easier to compare values on basis of time
 * and can be widely used in concurrent applications.
 * @param <T> Defined type
 */
public class StampedValue<T> {
    public long getStamp() {
        return stamp;
    }


    public T getValue() {
        return value;
    }


    private long stamp;
    private T value;

    public StampedValue(T initialValue){
        stamp = 0;
        value = initialValue;
    }

    public StampedValue(long stamp, T value){
        this.stamp = stamp;
        this.value = value;
    }

    public static StampedValue max(StampedValue x, StampedValue y){
        return x.stamp > y.stamp ? x:y;
    }

    public static StampedValue MIN_VALUE = new StampedValue(null);
}
