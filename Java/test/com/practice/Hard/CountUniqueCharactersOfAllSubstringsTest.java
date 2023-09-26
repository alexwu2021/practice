package com.practice.Hard;

import com.practice.Easy.Hard.CountUniqueCharactersOfAllSubstrings;
import org.junit.Assert;
import org.junit.Test;

public class CountUniqueCharactersOfAllSubstringsTest {

    @Test
    public void uniqueLetterString() {
        CountUniqueCharactersOfAllSubstrings sol = new CountUniqueCharactersOfAllSubstrings();
        String s;
        int actual, expected, actual2;

        s = "BAB";
        expected = 8;
        actual = sol.uniqueLetterString(s);
        Assert.assertEquals(expected, actual);
        actual2 = sol.uniqueLetterString_dp(s);
        System.out.println("s: " + s +"; expected: " + expected + "; actual2:" + actual2);
        Assert.assertEquals(expected, actual2);

        s = "ABC";
        expected = 10;
        //        Explanation: All possible substrings are: "A","B","C","AB","BC" and "ABC".
        //                Evey substring is composed with only unique letters.
        //                Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10
        actual = sol.uniqueLetterString(s);
        Assert.assertEquals(expected, actual);
        actual2 = sol.uniqueLetterString_dp(s);
        System.out.println("s: " + s +"; expected: " + expected + "; actual2:" + actual2);
        Assert.assertEquals(expected, actual2);


        s = "ABA";
        expected = 8;
        //Explanation: The same as example 1, except countUniqueChars("ABA") = 1.
        actual = sol.uniqueLetterString(s);
        Assert.assertEquals(expected, actual);
        actual2 = sol.uniqueLetterString_dp(s);
        System.out.println("s: " + s +"; expected: " + expected + "; actual2:" + actual2);
        Assert.assertEquals(expected, actual2);


        s = "LEETCODE";
        expected= 92;
        actual = sol.uniqueLetterString(s);
        Assert.assertEquals(expected, actual);
        actual2 = sol.uniqueLetterString_dp(s);
        System.out.println("s: " + s +"; expected: " + expected + "; actual2:" + actual2);
        Assert.assertEquals(expected, actual2);


    }
}