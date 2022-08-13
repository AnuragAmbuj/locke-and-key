package oss.concurrent.structures.model;

import org.junit.Assert;
import org.junit.Test;

public class PairTest{
    @Test
    public void testGetFirst() {
        final Pair<Integer, Integer> integerIntegerPair = new Pair<>();
        integerIntegerPair.setFirst(12);
        integerIntegerPair.setSecond(24);
        Assert.assertEquals(String.valueOf(integerIntegerPair.getFirst()),"12");
    }

    @Test
    public void testGetSecond() {
        final Pair<String, String> integerIntegerPair = new Pair<>();
        integerIntegerPair.setFirst("12");
        integerIntegerPair.setSecond("24");
        Assert.assertEquals(integerIntegerPair.getSecond(),"24");
    }
}