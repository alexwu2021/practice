package com.practice.Hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeEqualPartsTest {
    @Test
    public void threeEqualParts() {
        int [] Input = new int []{1,0,1,0,1};
        int[] res;
        ThreeEqualParts threeEqualParts = new ThreeEqualParts();
        res = threeEqualParts.threeEqualParts(Input);

        // [i, j]
        //  A[0], A[1], ..., A[i] is the first part;
        // * A[i+1], A[i+2], ..., A[j-1] is the second part, and
        // * A[j], A[j+1], ..., A[A.length - 1] is the third part.
        assert(res != null && res.length == 2);
        assert(res[0] == 0 && res[1] == 3);
    }
}