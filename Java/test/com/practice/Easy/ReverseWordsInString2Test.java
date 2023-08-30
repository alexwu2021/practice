package com.practice.Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsInString2Test {

    @Test
    public void reverseWords() {
        ReverseWordsInString2 reverseWordsInString2 = new ReverseWordsInString2();
        final char[] arr = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        char[] expected = {'b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e'};
        reverseWordsInString2.reverseWords(arr);
        for(int i = 0; i< arr.length; ++i)
            assert(arr[i] == expected[i]);
    }
}