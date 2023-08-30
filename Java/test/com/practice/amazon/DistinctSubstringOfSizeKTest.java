package com.practice.amazon;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DistinctSubstringOfSizeKTest {

    @Test
    public void getListOfDistinctSubstringOfSizeK() {

        DistinctSubstringOfSizeK sol = new DistinctSubstringOfSizeK();
        char[] src;
        int k;
        List<String> actual, expected = new ArrayList<>();

        src = new String("abcabc").toCharArray();
        expected = Arrays.asList(new String[] {"abc", "bca", "cab"});
        k = 3;
        actual = sol.getListOfDistinctSubstringOfSizeK(src, k);

        for(String a : actual){
            Assert.assertTrue(expected.contains(a));
        }
        for(String e : expected){
            Assert.assertTrue(actual.contains(e));
        }


        src = new String("abacab").toCharArray();
        expected = Arrays.asList(new String[] {"bac",  "cab"});
        k = 3;
        actual = sol.getListOfDistinctSubstringOfSizeK(src, k);

        for(String a : actual){
            Assert.assertTrue(expected.contains(a));
        }
        for(String e : expected){
            Assert.assertTrue(actual.contains(e));
        }



//        Input: s = "awaglknagawunagwkwagl", k = 4
//        Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]

        src = new String("awaglknagawunagwkwagl").toCharArray();
        expected = Arrays.asList(new String[] {"wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"});
        k = 4;
        actual = sol.getListOfDistinctSubstringOfSizeK(src, k);

        for(String a : actual){
            Assert.assertTrue(expected.contains(a));
        }
        for(String e : expected){
            Assert.assertTrue(actual.contains(e));
        }

    }
}