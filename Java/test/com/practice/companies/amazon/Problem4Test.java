package com.practice.companies.amazon;

import org.junit.Assert;
import org.junit.Test;

public class Problem4Test {

    @Test
    public void dosth4() {

        Problem4 problem4 = new Problem4();

        int actual, expected;

        actual = problem4.dosth4();
        expected = 4;
        Assert.assertEquals(expected, actual);
    }
}