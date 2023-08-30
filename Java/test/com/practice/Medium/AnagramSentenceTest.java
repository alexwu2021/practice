package com.practice.Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramSentenceTest {

    @Test
    public void isAnagramSentence() {
        AnagramSentence sol = new AnagramSentence();
        String s, t;
        boolean actual, expected;
        s = "cat robed";
        t = "tac bored";
        actual = sol.isAnagramSentence(s, t);
        expected = true;
        Assert.assertEquals(expected, actual);
    }
}