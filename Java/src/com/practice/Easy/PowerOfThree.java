package com.practice.Easy;

public class PowerOfThree {

    private static int x = (int)(Math.pow(3.0, 19.0)); // the max number of power of three, of int type
    public boolean isPowerOfThree(int n) {
        return n > 0 && x % n == 0;
    }
}
