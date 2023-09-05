package com.practice.Hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrogJumpTest {

    @Test
    void canCross() {
        FrogJump sol = new FrogJump();
        int[]stones = new int []{0,1,3,5,6,8,12,17};

        boolean expected, actual= sol.canCross(stones);
        expected = true;

        assertTrue(expected == actual);

        stones = new int[] {0,1,2,3,4,8,9,11};
        expected = false;
        actual= sol.canCross(stones);
        assertTrue(expected == actual);

    }
}