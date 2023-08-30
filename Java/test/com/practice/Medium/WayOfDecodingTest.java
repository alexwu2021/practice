package com.practice.Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class WayOfDecodingTest {

    @Test
    public void numDecodings() {
        WayOfDecoding sol = new WayOfDecoding();
        String s;
        int actual, expected;
        s = "11106";
        expected = 2;
        actual = sol.numDecodings(s);
        Assert.assertEquals(expected, actual);

        s = "10";
        expected = 1;
        actual = sol.numDecodings(s);
        Assert.assertEquals(expected, actual);

        s = "01";
        expected = 0;
        actual = sol.numDecodings(s);
        Assert.assertEquals(expected, actual);


    }
}