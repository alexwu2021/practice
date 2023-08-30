package com.practice.Easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DupsInArrayTest {

    @Test
    public void getAllTheDups() {
        DupsInArray sol = new DupsInArray();
        int[] source, ret, expected;

        source = new int[]{1, 2, 3, 2};
        expected = new int[]{2};
        ret = sol.getAllTheDups(source);
        Assert.assertArrayEquals(ret, expected);

        source = new int[]{1, 3, 3, 2};
        expected = new int[]{3};
        ret = sol.getAllTheDups(source);
        Assert.assertArrayEquals(ret, expected);

        source = new int[]{4, 2, 3, 2, 1};
        expected = new int[]{2};
        ret = sol.getAllTheDups(source);
        Assert.assertArrayEquals(ret, expected);

        source = new int[]{5, 2, 3, 2, 5};
        expected = new int[]{2, 5};
        ret = sol.getAllTheDups(source);
        Assert.assertArrayEquals(ret, expected);

        source = new int[]{5, 1, 4, 4, 5};
        expected = new int[]{4, 5};
        ret = sol.getAllTheDups(source);
        Assert.assertArrayEquals(ret, expected);
    }
}