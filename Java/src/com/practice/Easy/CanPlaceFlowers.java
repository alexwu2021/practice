package com.practice.Easy;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] f, int n) {
        for(int i = 0; i<f.length; ++i){
            int pre = i-1 < 0 ? 0 : f[i-1];
            int post = i == f.length-1 ? 0 : f[i+1];
            if(pre == 0 && post == 0 && f[i] == 0){
                f[i] = 1;
                n--;
            }
        }
        return n > 0 ? false : true;
    }
}
