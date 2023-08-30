package com.practice.Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VerifyingAnAlienDictionaryTest {

    @Test
    public void isAlienSorted() {
        VerifyingAnAlienDictionary sol = new VerifyingAnAlienDictionary();
        String[] words;
        String order;
        boolean actual, expected;

        words = new String[]{"hello","leetcode"};
        order = "hlabcdefgijkmnopqrstuvwxyz";
        actual = sol.isAlienSorted(words, order);
        expected = true;
        Assert.assertEquals(expected, actual);


        words = new String[]{"word","world","row"};
        order = "worldabcefghijkmnpqstuvxyz";
        actual = sol.isAlienSorted(words, order);
        expected = false;
        Assert.assertEquals(expected, actual);


        words = new String[]{"apple","app"};
        order = "abcdefghijklmnopqrstuvwxyz";
        actual = sol.isAlienSorted(words, order);
        expected = false;
        Assert.assertEquals(expected, actual);


        words = new String[]{"hello","hello"};
        order = "abcdefghijklmnopqrstuvwxyz";
        actual = sol.isAlienSorted(words, order);
        expected = true;
        Assert.assertEquals(expected, actual);


    }
}