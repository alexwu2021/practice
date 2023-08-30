package com.practice.Medium;

/**
 * find unique path in 2D array with some elements marked as obstacles (value === 1)
 */
public class UniquePath2 {

    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        // setup for the very first row and first column
        for (int i = 0; i < m; ++i) {
            if (grid[i][0] != 1)
                dp[i][0] = 1;
            else
                break;
        }

        for (int j = 0; j < n; ++j) {
            if (grid[0][j] != 1)
                dp[0][j] = 1;
            else
                break;
        }

        // exec dp
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }


    public int uniquePathsWithObstacles_formal(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        // setup for the very first row and first column
        for (int i = 0; i < m; ++i) {
            if (grid[i][0] == 1)  {
                dp[i][0] = 0;
                break;
            } else
                dp[i][0] = 1;
        }

        for (int j = 0; j < n; ++j) {
            if (grid[0][j] == 1)  {
                dp[0][j] = 0;
                break;
            } else
                dp[0][j] = 1;
        }

        // exec dp
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
