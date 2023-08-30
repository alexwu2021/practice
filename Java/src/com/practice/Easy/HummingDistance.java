package com.practice.Easy;

public class HummingDistance {

    /** passed oj
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int count = 0;
        for(int i = 31; i >= 0; i--){
            if(((temp >> i)  & 1)  > 0) count++;
        }
        return count;
    }


    public int hammingDistanceTheOtherWay(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

}
