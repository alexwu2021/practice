package com.practice.Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfGoodWaysToSplitAStringTest {

    @Test
    public void numSplits() {
        NumberOfGoodWaysToSplitAString sol = new NumberOfGoodWaysToSplitAString();
        String s;
        int actual, expected;


        s = "aacaba";
        actual = sol.numSplits(s);
        expected = 2;
        Assert.assertEquals(expected, actual);
    }
}