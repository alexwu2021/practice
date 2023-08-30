package com.practice.Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShiftingLettersTest {

    @Test
    public void shiftingLetters() {
        ShiftingLetters shiftingLetters = new ShiftingLetters();

        String s = "abc";
        int[]shifts = new int[]{3,5,9};
        String expected = "rpl";

        String res = shiftingLetters.shiftingLetters(s, shifts);
        Assert.assertTrue(res.equals(expected));
    }
}