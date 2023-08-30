package com.practice.Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Palindrom2Test {

    @Test
    public void validPalindrome() {
        Palindrom2 palindrom2 = new Palindrom2();
        String s = "aba";
        boolean res = palindrom2.validPalindrome(s);
        assert (res == true);

        s = "abca";
        res = palindrom2.validPalindrome(s);
        assert (res == true);
    }
}