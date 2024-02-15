package com.practice.Easy;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CircularMarathonTest {

    @Test
    void mostVisited() {
        int[] rounds = {1,3,5,7};
        int n = 7;
        List<Integer> actual, expected;

        // case 2: tail is bigger than head
        expected = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6,7});
        CircularMarathon sol = new CircularMarathon();
        actual = sol.mostVisited(n, rounds);
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());


        // case 2: tail is less than head
        rounds = new int[]{7, 3, 5, 1};
        n = 7;
        expected = Arrays.asList(new Integer[]{1, 7});
        actual = sol.mostVisited(n, rounds);
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        // case 2: tail is less than head
        rounds = new int[]{7, 3, 5, 1, 7};
        n = 7;
        expected = Arrays.asList(new Integer[]{7});
        actual = sol.mostVisited(n, rounds);
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

    }
}