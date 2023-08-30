package com.practice.Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class HIndexTest {

    @Test
    public void hIndex() {
        HIndex hIndex = new HIndex();
        int [] citations;
        int actual, expected;


        citations = new int[]{3,0,6,1,5};
        expected = 3;
        actual = hIndex.hIndex(citations);
        assertEquals(actual, expected);
    }
}