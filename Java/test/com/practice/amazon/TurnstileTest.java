package com.practice.amazon;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TurnstileTest {

    @Test
    public void turnsTileFunction() {

        Turnstile turnstile = new Turnstile();
        int[] times = new int[]{0, 0, 1, 5};
        int[] directions = new int[]{0, 1, 1, 0};
        int []expected = new int[]{2, 0, 1, 5};



        int[] ret = turnstile.turnsTileFunction(times, directions);

        Assert.assertArrayEquals(ret, expected);
    }
}