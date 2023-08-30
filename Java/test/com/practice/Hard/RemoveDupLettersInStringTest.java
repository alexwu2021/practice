package com.practice.Hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDupLettersInStringTest {

    @Test
    public void removeDuplicateLetters() {
        RemoveDupLettersInString removeDupLettersInString = new RemoveDupLettersInString();
        String S, actual, expected;

        S = "cbacdcbc";

        actual = removeDupLettersInString.removeDuplicateLetters(S);
        expected = "acdb";

        assertTrue(actual.equals(expected) && expected.equals(actual));

    }
}