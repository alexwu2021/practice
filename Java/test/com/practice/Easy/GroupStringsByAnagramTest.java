package com.practice.Easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupStringsByAnagramTest {

    @Test
    void groupStringsByAnagram() {

        GroupStringsByPalindrom sol = new GroupStringsByPalindrom();

        List<String> input = Arrays.asList(new String []{"CAT", "TAC", "EAT", "DEF", "TEA", "TCA"});
        List<List<String>> expected, actual;

        actual = sol.groupStringsByAnagram(input);

        expected = new ArrayList<>();
        expected.add(Arrays.asList(new String[]{"CAT", "TAC", "TCA"}));
        expected.add(Arrays.asList(new String[]{"EAT", "TEA"}));
        expected.add(Arrays.asList(new String[]{"DEF"}));

        assertArrayEquals(expected.stream().toArray(), actual.stream().toArray());
    }

    @Test
    void groupStringsByAnagram_withDups() {

        GroupStringsByPalindrom sol = new GroupStringsByPalindrom();

        List<String> input = Arrays.asList(new String []{"CAT", "TAC", "TTAACC", "EAT", "DEF", "TEA", "TCA", "TCAAA"});
        List<List<String>> expected, actual;

        actual = sol.groupStringsByAnagram(input);

        expected = new ArrayList<>();
        expected.add(Arrays.asList(new String[]{"CAT", "TAC",  "TTAACC", "TCA", "TCAAA"}));
        expected.add(Arrays.asList(new String[]{"EAT", "TEA"}));
        expected.add(Arrays.asList(new String[]{"DEF"}));

        assertArrayEquals(expected.stream().toArray(), actual.stream().toArray());
    }
}