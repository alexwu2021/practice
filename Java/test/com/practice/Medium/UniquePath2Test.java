package com.practice.Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniquePath2Test {

    @Test
    public void uniquePathsWithObstacles() {
        UniquePath2 uniquePath2 = new UniquePath2();
        int[][]grid;
        int res, expected;
        grid = new int[][]{{1, 0}};
        expected = 0;
        res = uniquePath2.uniquePathsWithObstacles(grid);
        assert (res == expected);
    }
}