package com.practice.amazon;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemsInContainTest {

    @Test
    public void getNumberOfItems() {

        ItemsInContain itemsInContain = new ItemsInContain();
        String s = "|**|*|";
        int[] startIndices = new int[]{1, 1};
        int[] endIndices = new int[]{5, 6};

        int[] actual = itemsInContain.getNumberOfItems(s, startIndices, endIndices);
        int[] expected = new int[]{2, 3};
        Assert.assertArrayEquals(expected, actual);


        s = "*|*|";
        startIndices = new int[]{1};
        endIndices = new int[]{3};

        actual = itemsInContain.getNumberOfItems(s, startIndices, endIndices);
        expected = new int[]{0};
        Assert.assertArrayEquals(expected, actual);
    }
}