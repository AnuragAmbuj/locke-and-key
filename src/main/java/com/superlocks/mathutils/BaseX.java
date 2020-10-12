package com.superlocks.mathutils;

import java.math.BigInteger;

public class BaseX {

    private BigInteger bigInteger;

    public BaseX(String number, Radix sourceRadix){
        bigInteger = new BigInteger(number, sourceRadix.getValue());
    }

    public BaseX(String number){
        bigInteger = new BigInteger(number, Radix.BASE_10.getValue());
    }

    public String decode(Radix destinationRadix){
        return bigInteger.toString(destinationRadix.getValue());
    }

    public enum Radix{
        BASE_64(64),
        BASE_10(10),
        BASE_16(16);

        private int value;
        Radix(int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }
    }
}
