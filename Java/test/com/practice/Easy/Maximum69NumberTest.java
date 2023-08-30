package com.practice.Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Maximum69NumberTest {

    @Test
    public void maximum69Number() {
        Maximum69Number sol = new Maximum69Number();
        int num, actual, expected;

        num = 9669;
        expected = 9969;
        actual = sol.maximum69Number(num);
        Assert.assertEquals(expected, actual);

        num = 9996;
        expected = 9999;
        actual = sol.maximum69Number(num);
        Assert.assertEquals(expected, actual);

    }
}