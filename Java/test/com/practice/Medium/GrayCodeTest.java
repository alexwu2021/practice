package com.practice.Medium;

import org.junit.Test;

import java.util.List;

public class GrayCodeTest {

    @Test
    public void grayCode() {
        GrayCode grcd = new GrayCode();
        List<Integer> actual;
//        List<Integer> expected = Arrays.asList(0,1,3,2);
//        List<Integer> expected2 = Arrays.asList(0,2,3,1);
//
//        actual = grcd.grayCode(2);
//        assertTrue(actual.containsAll(expected) && expected.containsAll(actual)
//                || actual.containsAll(expected2) && expected2.containsAll(actual));

        actual = grcd.grayCode(3);



    }
}