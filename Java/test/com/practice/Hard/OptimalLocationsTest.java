package com.practice.Hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptimalLocationsTest {

    @Test
    void optimalLocations() {
        OptimalLocations sol = new OptimalLocations();
        int[] inputs = new int[]{-2, 1, 0};
        int actual, expected, k = 8;
        actual = sol.optimalLocations(inputs, k);
        expected = 3;
        assertEquals(expected, actual);
    }
}