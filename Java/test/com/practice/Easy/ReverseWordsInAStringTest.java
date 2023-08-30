package com.practice.Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsInAStringTest {

    @Test
    public void reverseWords() {

        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        String source = "a good   example";
        String expected, actual;
        actual = reverseWordsInAString.reverseWords(source);
        expected = "example good a";
        assert(actual.equals(expected));

    }
}