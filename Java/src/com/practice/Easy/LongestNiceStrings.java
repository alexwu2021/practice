package com.practice.Easy;
import java.util.*;

/**
 *
 * 1763
 *
 * A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase.
 * For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b'
 * appears, but 'B' does not.
 */
public class LongestNiceStrings {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";

        Set<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        for (char c: arr) set.add(c);

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c)))
                continue;

            // dividing point: the section of [0, i) may still bear a group of nice substrings
            // but ith character may be safe discarded

            String sub1 = longestNiceSubstring(s.substring(0, i)), sub2 = longestNiceSubstring(s.substring(i+1));
            return sub1.length() >= sub2.length() ? sub1 : sub2;
        }
        return s;
    }
}
