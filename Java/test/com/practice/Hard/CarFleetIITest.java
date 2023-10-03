package com.practice.Hard;

import org.junit.Assert;
import org.junit.Test;

public class CarFleetIITest {

    @Test
    public void getCollisionTimes() {
        CarFleetII sol = new CarFleetII();
        int[][] pspeeds;
        int i;
        double[] expected;
        double[] actual;
        double delta = 0.0001;

//        i=0;
//        pspeeds = new int[3][2];
//        pspeeds[i++] = new int[]{5, 3};
//        pspeeds[i++] = new int[]{7, 2};
//        pspeeds[i++] = new int[]{12, 1};
//        expected = new double[]{2, 7, -1};
//        actual = sol.getCollisionTimes(pspeeds);
//        Assert.assertEquals(expected, actual);

//        i=0;
//        pspeeds = new int[4][2];
//        pspeeds[i++] = new int[]{1, 2};
//        pspeeds[i++] = new int[]{2, 1};
//        pspeeds[i++] = new int[]{4, 3};
//        pspeeds[i++] = new int[]{7, 2};
//        expected = new double[]{1.00000,-1.00000,3.00000,-1.00000};
//        actual = sol.getCollisionTimes(pspeeds);
//        Assert.assertArrayEquals("not match", expected, actual, delta);


        i=0;
        pspeeds = new int[4][2];
        pspeeds[i++] = new int[]{3, 4};
        pspeeds[i++] = new int[]{5, 4};
        pspeeds[i++] = new int[]{6, 3};
        pspeeds[i++] = new int[]{9, 1};
        expected = new double[]{2.00000,1.00000,1.50000,-1.00000};
        actual = sol.getCollisionTimes(pspeeds);
        Assert.assertArrayEquals("not match", expected, actual, delta);
    }
}