package com.practice.Medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LetterCombinationsTest {

    @Test
    public void letterCombinations() {
        LetterCombinations letterCombinations = new LetterCombinations();
        String digits;
        List<String> expected, actual;

        digits = "2";
        actual = letterCombinations.letterCombinations(digits);
        expected = Arrays.asList(new String[]{"a", "b", "c"});
        assertNotNull(actual);
        assertEquals(actual.size(), expected.size());

        digits = "23";
        actual = letterCombinations.letterCombinations(digits);
        expected = Arrays.asList(new String[]{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"});
        assertNotNull(actual);
        assertEquals(actual.size(), expected.size());
        assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));

        digits = "234";
        actual = letterCombinations.letterCombinations(digits);
        expected = Arrays.asList(new String[]{"adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"});
        assertNotNull(actual);
        assertEquals(actual.size(), expected.size());
        assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
    }
}