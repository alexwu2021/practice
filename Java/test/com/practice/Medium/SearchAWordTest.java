package com.practice.Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchAWordTest {

    @Test
    public void find() {

        SearchAWord sol = new SearchAWord();
        String[] words = new String[]{"cat", "baby", "bird", "bird", "car", "ax"};

        String actual, expected;

        String string1 = "tcabnihjs";
        expected = "cat";
        actual = sol.find(words, string1);
        Assert.assertEquals(expected, actual);


        String string2 = "tbcabnihjs";
        expected = "cat";
        actual = sol.find(words, string2);
        Assert.assertEquals(expected, actual);

        String string3 = "baykkjl";
        expected = null;
        actual = sol.find(words, string3);
        Assert.assertEquals(expected, actual);

        String string4 = "bbabylkk";
        expected = "baby";
        actual = sol.find(words, string4);
        Assert.assertEquals(expected, actual);

        String string5 = "ccc";
        expected = null;
        actual = sol.find(words, string5);
        Assert.assertEquals(expected, actual);

        String string6 = "breakmaking";
        expected = null;
        actual = sol.find(words, string6);
        Assert.assertEquals(expected, actual);


    }
}