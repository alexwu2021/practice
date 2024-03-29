package com.practice.Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveSubStringsTest {

    @Test
    public void removeOccurrences() {
        RemoveSubStrings sol = new RemoveSubStrings();
        String s, part, actual, expected;


//        Example 1:

//        Input: s = "daabcbaabcbc", part = "abc"
//        Output: "dab"
//        Explanation: The following operations are done:
//        - s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
//                - s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
//                - s = "dababc", remove "abc" starting at index 3, so s = "dab".
//                Now s has no occurrences of "abc".
        s= "daabcbaabcbc";
        part = "abc";
        actual = sol.removeOccurrences(s, part);
        expected = "dababc";
        Assert.assertEquals(expected, actual);



//        Example 2:
//
//        Input: s = "axxxxyyyyb", part = "xy"
//        Output: "ab"
//        Explanation: The following operations are done:
//        - s = "axxxxyyyyb", remove "xy" starting at index 4 so s = "axxxyyyb".
//        - s = "axxxyyyb", remove "xy" starting at index 3 so s = "axxyyb".
//        - s = "axxyyb", remove "xy" starting at index 2 so s = "axyb".
//        - s = "axyb", remove "xy" starting at index 1 so s = "ab".
//                Now s has no occurrences of "xy".
//        s= "axxxxyyyyb";
//        part = "xy";
//        actual = sol.removeOccurrences(s, part);
//        expected = "ab";
//        Assert.assertEquals(expected, actual);


    }
}