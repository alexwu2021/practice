package com.practice.Easy;

public class SmallestRangeI {

    public int smallestRangeI(int[] A, int k) {
        int n = A.length;
        int min = A[0];
        int max = A[0];

        for(int i = 0; i < n; i++){
            min = Math.min(min,A[i]);
            max = Math.max(max,A[i]);
        }

        if(max - k <= min + k){ // it is less than or equal to
            return 0;
        } else {
            return  (max - k) - (min + k);
        }

        //return (min+k >= max-k) ? 0 : (max-k) - (min+k);
    }
}
