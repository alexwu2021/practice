package com.practice.Hard;

import com.practice.Easy.Hard.LongestValidParentheses;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LongestValidParenthesesTest {

    private LongestValidParentheses sol;

    private String s1 = "(()())))";
    @Test
    public void lvp() {
        int actual = sol.longestValidParentheses(this.s1);
        int expected = 6;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void longestValidParentheses() {
        int actual = sol.lvp(this.s1);
        int expected = 6;
        Assert.assertEquals(expected, actual);
    }


    @Before
    public void setUp() throws Exception {
        sol = new LongestValidParentheses();
    }

    @After
    public void tearDown() throws Exception {
    }
}