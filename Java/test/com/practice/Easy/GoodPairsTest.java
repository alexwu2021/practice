package com.practice.Easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoodPairsTest {

    GoodPairs sol = new GoodPairs();
    @Test
    void numIdenticalPairs() {
        int [] nums = new int []{1,2,3,1,1,3};
        int expected, actual;
        actual = sol.numIdenticalPairs(nums);
        expected = 4;
        assertEquals(expected, actual);
    }
}