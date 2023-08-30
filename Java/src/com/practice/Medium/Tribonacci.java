package com.practice.Medium;

public class Tribonacci {
    long next(long currIndex){
        if(currIndex == 0){
            return 0;
        }
        if(currIndex <= 2){
            return 1;
        }

        long curr = Long.MIN_VALUE, prev = 1, prevPrev = 1, prevPrevPrev = 0;
        int i;
        for(i = 3; i<=currIndex; ++i){
            curr = prev +  prevPrev + prevPrevPrev;
            prevPrevPrev = prevPrev;
            prevPrev = prev;
            prev = curr;
        }
        return curr;
    }
}
