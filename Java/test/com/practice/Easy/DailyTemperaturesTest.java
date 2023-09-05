package com.practice.Easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DailyTemperaturesTest {

    @Test
    void dailyTemperatures() {
        DailyTemperatures sol = new DailyTemperatures();
        int[] actual, expected, input;

        input = new int[]{73,74,75,71,69,72,76,73};
        expected = new int[]{1,1,4, 2, 1,1,0, 0};

         actual = sol.dailyTemperatures(input);
        assertArrayEquals(expected, actual);
    }
}