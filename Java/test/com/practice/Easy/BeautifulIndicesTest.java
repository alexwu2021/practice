package com.practice.Easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BeautifulIndicesTest {

    @Test
    void beautifulIndices() {
        BeautifulIndices sol = new BeautifulIndices();
        String s, a, b;
        int k;
        List<Integer> actual, expected;

        s = "isawsquirrelnearmysquirrelhouseohmy";
        a = "my";
        b = "squirrel";
        k = 15;
        actual = sol.beautifulIndices(s, a, b, k);
        expected = Arrays.asList(new Integer[]{16, 33});
        assertArrayEquals(expected.toArray(), actual.toArray());

        s = "abcd";
        a = "a";
        b = "a";
        k = 4;
        actual = sol.beautifulIndices(s, a, b, k);
        expected = Arrays.asList(new Integer[]{0});
        assertArrayEquals(expected.toArray(), actual.toArray());



        s = "bavgoc";
        a = "ba";
        b = "c";
        k = 6;
        actual = sol.beautifulIndices(s, a, b, k);
        expected = Arrays.asList(new Integer[]{0});
        assertArrayEquals(expected.toArray(), actual.toArray());


    }
}