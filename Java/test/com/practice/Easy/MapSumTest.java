package com.practice.Easy;

import org.junit.Test;

import java.util.Random;

public class MapSumTest {
    @Test
    public void testNullAllowedAndSummable() {
        MapSum mapSum = new MapSum();
        Random random = new Random(System.currentTimeMillis());
        int expected = random.nextInt(1000);
        mapSum.insert(null, expected);
        int sm = mapSum.sum(null);
        assert(sm == expected);
    }
}