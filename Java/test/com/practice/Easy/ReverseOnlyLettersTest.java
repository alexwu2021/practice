package com.practice.Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseOnlyLettersTest {

    @Test
    public void reverseOnlyLetters() {
        ReverseOnlyLetters sol = new ReverseOnlyLetters();

        String s = "ab-cd";
        String expected = "dc-ba";
        String actual;
//        actual = sol.reverseOnlyLetters(s);
//        Assert.assertEquals(expected, actual);

        s = "a-bC-dEf-ghIj";
        expected= "j-Ih-gfE-dCba";
        actual = sol.reverseOnlyLetters(s);
        Assert.assertEquals(expected, actual);

        s = "Test1ng-Leet=code-Q!";
        expected =  "Qedo1ct-eeLg=ntse-T!";
        actual = sol.reverseOnlyLetters(s);
        Assert.assertEquals(expected, actual);

    }
}