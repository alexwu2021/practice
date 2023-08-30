package com.practice.companies.amazon;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FriendCircleTest {

    @Test
    public void findCircleNum() {

        int actual, expected;
        FriendCircle friendCircle = new FriendCircle();
        List<List<Integer>>M = new ArrayList<>();
//        M.add(Arrays.asList(new Integer[]{1, 1, 0}));
//        M.add(Arrays.asList(new Integer[]{1, 1, 0}));
//        M.add(Arrays.asList(new Integer[]{0, 0, 1}));
//        expected = 2;
//        actual = friendCircle.findCircleNum(M);
//        Assert.assertEquals(expected, actual);

        M.clear();
        M.add(Arrays.asList(new Integer[]{1, 1, 0, 0}));
        M.add(Arrays.asList(new Integer[]{1, 1, 0, 0}));
        M.add(Arrays.asList(new Integer[]{0, 0, 1, 0}));
        M.add(Arrays.asList(new Integer[]{1, 1, 0, 0}));
        expected = 3;
        actual = friendCircle.findCircleNum(M);
        Assert.assertEquals(expected, actual);


        M.clear();
        M.add(Arrays.asList(new Integer[]{1, 1, 0, 0}));
        M.add(Arrays.asList(new Integer[]{1, 1, 1, 0}));
        M.add(Arrays.asList(new Integer[]{0, 1, 1, 0}));
        M.add(Arrays.asList(new Integer[]{1, 1, 0, 0}));
        expected = 1;
        actual = friendCircle.findCircleNum(M);
        Assert.assertEquals(expected, actual);

    }
}