package com.practice.Easy;


import org.junit.Assert;
import org.junit.Test;


public class DeleteGreatestFromGridTest {

    @Test
    public void testDeleteGreatestValue() {
        DeleteGreatestFromGrid sol = new DeleteGreatestFromGrid();
        int [][]grid;

        //[[1,2,4],[3,3,1]]
        grid = new int[][]{new int[]{1,2,4}, new int[]{3,3,1}};
        int actual = sol.deleteGreatestValue(grid);
        int expected = 8;
        Assert.assertEquals(expected, actual);


        grid = new int[][]{new int[]{10}};
        actual = sol.deleteGreatestValue(grid);
        expected = 10;
        Assert.assertEquals(expected, actual);
    }
}