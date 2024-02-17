package com.practice.Medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumCostSubstringTest {

    @Test
    void maximumCostSubstring() {

        MaximumCostSubstring sol = new MaximumCostSubstring();
        String s, chars;
        int[] vals;
        int actual, expected;
        s = "hghhghgghh";
        chars = "hg";
        vals = new int[]{2, 3};
        actual = sol.maximumCostSubstring(s, chars, vals);
        expected = 24;
        assertEquals(expected, actual);
    }
}