package com.practice.Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class KokoEatsBananaTest {

    @Test
    public void minEatingSpeed() {
        KokoEatsBanana sol = new KokoEatsBanana();
        int[] piles;
        int H, actual, expected;


        piles = new int[]{2, 2};
        H = 2;
        expected = 2;
        actual = sol.minEatingSpeed(piles, H);
        Assert.assertEquals(expected, actual);

        piles = new int[]{3,6,7,11};
        H = 8;
        expected = 4;
        actual = sol.minEatingSpeed(piles, H);
        Assert.assertEquals(expected, actual);

        piles = new int[]{30,11,23,4,20};
        H = 5;
        expected = 30;
        actual = sol.minEatingSpeed(piles, H);
        Assert.assertEquals(expected, actual);

        piles = new int[]{30,11,23,4,20};
        H = 6;
        expected = 23;
        actual = sol.minEatingSpeed(piles, H);
        Assert.assertEquals(expected, actual);

        piles = new int[]{30,11,23,4,20};
        H = 6;
        expected = 23;
        actual = sol.minEatingSpeed(piles, H);
        Assert.assertEquals(expected, actual);
    }
}