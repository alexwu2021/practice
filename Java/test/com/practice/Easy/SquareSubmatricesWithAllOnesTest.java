package com.practice.Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareSubmatricesWithAllOnesTest {

    @Test
    public void countSquares() {
        SquareSubmatricesWithAllOnes sol = new SquareSubmatricesWithAllOnes();
        int[][] A;
        int actual, expeted;
        A = new int[][]{
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        };
        expeted = 15;
        actual = sol.countSquares(A);
        Assert.assertEquals(expeted, actual);
    }
}