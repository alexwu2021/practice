package com.practice.Medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WordBreakTest {

    @Test
    public void wordBreak() {
        WordBreak wordBreak = new WordBreak();
        String s;
        List<String> lst;
        s = "leetacode";
        lst = new ArrayList<>(Arrays.asList("leet", "code", "a"));
        boolean res;
        res = wordBreak.wordBreak(s, lst);
        assert(res == true);


    }
}