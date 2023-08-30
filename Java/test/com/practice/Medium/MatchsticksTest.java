package com.practice.Medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchsticksTest {

    @Test
    void makesquare() {
        Matchsticks matchsticks = new Matchsticks();
        int[] inputs = {1, 1, 2, 2, 3, 4, 1, 1, 1};
        boolean actual;

        actual = matchsticks.makesquare(inputs);
        assertTrue(actual);
    }
}