package com.practice.companies.amazon;

import org.junit.Assert;
import org.junit.Test;

public class Problem3Test {

    @Test
    public void dosth3() {

        Problem3 problem3 = new Problem3();

        int actual, expected;

        actual = problem3.dosth3();
        expected = 3;
        Assert.assertEquals(expected, actual);
    }
}