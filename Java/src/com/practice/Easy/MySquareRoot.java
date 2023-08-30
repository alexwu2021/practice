package com.practice.Easy;

public class MySquareRoot {

    /** passed oj
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        long r = x;
        while(r * r > x){
            r = (r + x / r) / 2 ;  // X(n+1) = 0.5 * (X(n) + S /X(n) ), pay attention: it is x/r !!
        }
        return (int) r;
    }
}
