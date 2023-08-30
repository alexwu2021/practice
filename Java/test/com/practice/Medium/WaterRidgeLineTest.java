package com.practice.Medium;

import Medium.WaterRidgeLine;
import org.junit.Test;

import java.util.List;

public class WaterRidgeLineTest {

    @Test
    public void pacificAtlantic() {
//        Pacific ~   ~   ~   ~   ~
//                ~  1   2   2   3  (5) *
//                ~  3   2   3  (4) (4) *
//                ~  2   4  (5)  3   1  *
//                ~ (6) (7)  1   4   5  *
//                ~ (5)  1   1   2   4  *
//          *   *   *   *   * Atlantic
//



        int [][] dir = new int[][]
                {
                        new int[]{-1, 0},
                        new int[]{0, 1},
                        new int[]{1, 0},
                        new int[]{0, -1}
                };


        int[][]matrix = new int[5][5];
        int i = 0, j = 0;
        matrix[i][j++] = 1;
        matrix[i][j++] = 2;
        matrix[i][j++] = 2;
        matrix[i][j++] = 3;
        matrix[i][j++] = 5;

        i++; j = 0;
        matrix[i][j++] = 3;
        matrix[i][j++] = 2;
        matrix[i][j++] = 3;
        matrix[i][j++] = 4;
        matrix[i][j++] = 4;

        i++; j = 0;
        matrix[i][j++] = 2;
        matrix[i][j++] = 4;
        matrix[i][j++] = 5;
        matrix[i][j++] = 3;
        matrix[i][j++] = 1;

        i++; j = 0;
        matrix[i][j++] = 6;
        matrix[i][j++] = 7;
        matrix[i][j++] = 1;
        matrix[i][j++] = 4;
        matrix[i][j++] = 5;

        i++; j = 0;
        matrix[i][j++] = 5;
        matrix[i][j++] = 1;
        matrix[i][j++] = 1;
        matrix[i][j++] = 2;
        matrix[i][j++] = 4;

        WaterRidgeLine waterRidgeLine = new WaterRidgeLine();
        List<int[]> res = waterRidgeLine.pacificAtlantic(matrix);

        assert(res.size() == 7);
//        assert(res.contains(new int[]{0, 4}));
//        assert(res.contains(new int[]{1, 3}));
//        assert(res.contains(new int[]{1, 4}));
//        assert(res.contains(new int[]{2, 2}));
//        assert(res.contains(new int[]{3, 0}));
//        assert(res.contains(new int[]{3, 1}));
//        assert(res.contains(new int[]{4, 0}));
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]

    }
}