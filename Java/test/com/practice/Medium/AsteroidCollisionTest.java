package com.practice.Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AsteroidCollisionTest {

    @Test
    public void asteroidCollision() {
        AsteroidCollision sol = new AsteroidCollision();
        int[] a, actual, expected;

        a = new int[]{10,2,-5};
        expected = new int[]{10};
        actual = sol.asteroidCollision(a);
        Assert.assertArrayEquals(expected, actual);
    }
}