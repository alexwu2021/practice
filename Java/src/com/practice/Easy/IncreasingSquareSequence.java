package com.practice.Easy;

public class IncreasingSquareSequence {


    /** not checked with OJ, but just the same idea
     *
     * i myself wrote a version that passed the OJ, using hasZero and hasSignChanged.
     *
     *  but this one is more elegant!!
     * @param A
     * @return
     */
    int[] findIncreasingSquares(int [] A){
        if(A == null || A.length <= 0)
            return null;

        int n = A.length;
        int[] ret = new int[n];
        int j = n -1;
        for(int left = 0, right = n - 1; left < n && right >= 0 && left < right ; ){
            if(A[left] * A[left] > A[right] * A[right]){
                ret[j] = A[left] * A[left++];
            } else{
                ret[j] = A[right] * A[right--];
            }
            j--;
        }
        return ret;
    }
}
