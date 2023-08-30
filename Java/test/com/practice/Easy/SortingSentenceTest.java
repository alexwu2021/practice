package com.practice.Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortingSentenceTest {

    @Test
    public void sortSentence() {
        SortingSentence sol = new SortingSentence();
        String s, actual, expected, actual_ref, actual_ref2;

//        s = "is2 sentence4 This1 a3";
//        expected = "This is a sentence";
//        actual = sol.sortSentence(s);
//        Assert.assertEquals(expected, actual);
//
//        s = "Myself2 Me1 I4 and3";
//        expected =  "Me Myself and I";
//        actual = sol.sortSentence(s);
//        Assert.assertEquals(expected, actual);

        s = "Myself2 Me1 I4 and3 finish6 the7 great8 challenge9 altogether10 this11 time12 will5";
        expected =  "Me Myself and I will finish the great challenge altogether this time";
        actual = sol.sortSentence(s);
        //actual_ref = sol.sortSentence_ref(s);
        actual_ref2 = sol.sortSentence_ref2(s);
        Assert.assertEquals(expected, actual);
    }
}