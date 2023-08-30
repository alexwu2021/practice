package com.practice.companies.amazon;

import org.junit.Assert;
import org.junit.Test;

public class JoinRopesTest {

    @Test
    public void findLeastCostOfJoiningRopes() {

        JoinRopes joinRopes = new JoinRopes();
        int[] src = new int[]{8, 4, 6, 12};
        int expected = 58;
        int actual = joinRopes.findLeastCostOfJoiningRopes(src);
        Assert.assertEquals(expected, actual);

        src = new int[]{20, 4, 8, 2};
        expected = 54;
        actual = joinRopes.findLeastCostOfJoiningRopes(src);
        Assert.assertEquals(expected, actual);

        src = new int[]{1, 2, 5, 10, 35, 89};
        expected = 224;
        actual = joinRopes.findLeastCostOfJoiningRopes(src);
        Assert.assertEquals(expected, actual);

        src = new int[]{2, 2, 3, 3};
        expected = 20;
        actual = joinRopes.findLeastCostOfJoiningRopes(src);
        Assert.assertEquals(expected, actual);
    }
}