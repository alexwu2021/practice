package com.practice.Medium;

import org.junit.Assert;
import org.junit.Test;

public class BreakAPalindromTest {

    @Test
    public void breakPalindrome() {

        BreakAPalindrom sol = new BreakAPalindrom();
        String input, actual, expected;

        input = "aba";
        expected = "abb";
        actual = sol.breakPalindrome(input);
        Assert.assertEquals(expected, actual);

        input = "abccba";
        expected = "aaccba";
        actual = sol.breakPalindrome(input);
        Assert.assertEquals(expected, actual);

        input = "aa";
        expected = "ab";
        actual = sol.breakPalindrome(input);
        Assert.assertEquals(expected, actual);

        input = "aaa";
        expected = "aab";
        actual = sol.breakPalindrome(input);
        Assert.assertEquals(expected, actual);

        input = "aabaa";
        expected = "aabab"; // currently i got this aabba
        actual = sol.breakPalindrome(input);
        Assert.assertEquals(expected, actual);

    }
}