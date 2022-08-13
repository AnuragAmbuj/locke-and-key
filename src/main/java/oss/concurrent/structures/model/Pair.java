package oss.concurrent.structures.model;

import java.io.Serializable;
import java.util.Comparator;

public class Pair<K extends Comparable,V extends Comparable> implements Serializable, Comparable<Pair<K,V>>, Comparator<Pair<K,V>> {

    private K first;
    private V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public Pair(Pair<K, V> pair) {
        this.first = pair.first;
        this.second = pair.second;
    }

    public Pair() {
        super();
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public void setFirst(K first) {
        this.first = first;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    @Override
    public int hashCode() {
        return first.hashCode() >> 2 & second.hashCode() >> 2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            final Pair p = (Pair) obj;
            if (this == p) {
                return this.first.equals(p.first) && this.second.equals(p.second);
            }
        }
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @Override
    public String toString() {
        return "(" + first.toString() + "," + second.toString() + ")";
    }

    @Override
    @Deprecated
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public int compareTo(Pair<K, V> o) {
        return o.first.compareTo(this.first) & o.second.compareTo(this.second);
    }

    @Override
    public int compare(Pair<K, V> o1, Pair<K, V> o2) {
        return o1.first.compareTo(o2.first) & o1.second.compareTo(o2.second);
    }

    @Override
    public Comparator<Pair<K, V>> reversed() {
        return (o1, o2) -> o2.first.compareTo(o1.first) & o2.second.compareTo(o1.second);
    }

    @Override
    public Comparator<Pair<K, V>> thenComparing(Comparator<? super Pair<K, V>> other) {
        return ((Comparator<Pair<K, V>>) (o1, o2) -> o1.first.compareTo(o2.first) & o1.second.compareTo(o2.second)).thenComparing(other);
    }
}
