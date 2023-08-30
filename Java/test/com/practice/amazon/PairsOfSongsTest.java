package com.practice.amazon;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PairsOfSongsTest {

    @Test
    public void getNumberOfPairs() {

        PairsOfSongs pairsOfSongs = new PairsOfSongs();
        int[] times = new int[]{30,20,150,100,40};
        int actual = pairsOfSongs.getNumberOfPairs(times);

        int expected = 3;
        Assert.assertEquals(expected, actual);


        times = new int[]{60, 60, 60};
        Assert.assertEquals(expected, actual);
    }
}