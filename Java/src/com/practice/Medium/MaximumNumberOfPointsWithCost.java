package com.practice.Medium;

/**
 * You are given an m x n integer matrix points (0-indexed). Starting with 0 points, you want to maximize the number of points you can get from the matrix.
 *
 * To gain points, you must pick one cell in each row. Picking the cell at coordinates (r, c) will add points[r][c] to your score.
 *
 * However, you will lose points if you pick a cell too far from the cell that you picked in the previous row. For every two adjacent rows r and r + 1 (where 0 <= r < m - 1), picking cells at coordinates (r, c1) and (r + 1, c2) will subtract abs(c1 - c2) from your score.
 *
 * Return the maximum number of points you can achieve.
 *
 * abs(x) is defined as:
 *
 * x for x >= 0.
 * -x for x < 0.
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[1,2,3],[1,5,1],[3,1,1]]
 * Output: 9
 * Explanation:
 * The blue cells denote the optimal cells to pick, which have coordinates (0, 2), (1, 1), and (2, 0).
 * You add 3 + 5 + 3 = 11 to your score.
 * However, you must subtract abs(2 - 1) + abs(1 - 0) = 2 from your score.
 * Your final score is 11 - 2 = 9.
 * Example 2:
 *
 *
 * Input: points = [[1,5],[2,3],[4,2]]
 * Output: 11
 * Explanation:
 * The blue cells denote the optimal cells to pick, which have coordinates (0, 1), (1, 1), and (2, 0).
 * You add 5 + 3 + 4 = 12 to your score.
 * However, you must subtract abs(1 - 1) + abs(1 - 0) = 1 from your score.
 * Your final score is 12 - 1 = 11.
 */
public class MaximumNumberOfPointsWithCost {

    /**
     * iteration and tabulation
     * @param g
     * @return
     */
    public long maxPoints(int[][] g) {
        int m = g.length, n = g[0].length;
        long[] prev = new long[n];
        for (int i = 0; i < n; ++i) prev[i] = g[0][i];

        for (int r = 0; r < m - 1; ++r){
            long[] left = new long[n], // values reflecting pathes coming via the cells to thr left of i
                    right = new long[n], // ditto right
                    curr = new long[n];

            left[0] = prev[0];
            for (int c = 1; c < n; ++c)
                left[c] = Math.max(left[c - 1] - 1, prev[c]);  // -1 reflects the constraint: substract by the distance away from i

            right[n - 1] = prev[n - 1];
            for (int c = n - 2; c >= 0; --c)
                right[c] = Math.max(right[c + 1] - 1, prev[c]);


            for (int c = 0; c < n; ++c)
                curr[c] = g[r + 1][c] + Math.max(left[c], right[c]);
            prev = curr;
        }

        long ans = 0;
        for (int i = 0; i < n; ++i)
            ans = Math.max(ans, prev[i]);
        return ans;
    }

    // ? not seeing recursion is an option
}
