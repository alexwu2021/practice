package com.practice.Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DecryptStringFromAlphabet2IntegerMappingTest {

    @Test
    public void freqAlphabets() {
        DecryptStringFromAlphabet2IntegerMapping sol = new DecryptStringFromAlphabet2IntegerMapping();
        String s, actual, expected;

        //Input: s = "10#11#12"
        //Output: "jkab"
        //Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
        s = "10#11#12";
        expected = "jkab";
        actual = sol.freqAlphabets(s);
        Assert.assertEquals(expected, actual);

        //Input: s = "1326#"
        //Output: "acz"
        s = "1326#";
        expected = "acz";
        actual = sol.freqAlphabets(s);
        Assert.assertEquals(expected, actual);


        //Input: s = "25#"
        //Output: "y"
        s = "25#";
        expected = "y";
        actual = sol.freqAlphabets(s);
        Assert.assertEquals(expected, actual);

        //Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
        //Output: "abcdefghijklmnopqrstuvwxyz"
        s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
        expected = "abcdefghijklmnopqrstuvwxyz";
        actual = sol.freqAlphabets(s);
        Assert.assertEquals(expected, actual);


    }
}