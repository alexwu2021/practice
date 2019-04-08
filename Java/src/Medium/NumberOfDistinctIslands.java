package Medium;

import java.util.*;

public class NumberOfDistinctIslands {

    private static final int[][] delta = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    /** passed oj
     * @param grid
     * @return
     */
    public int numDistinctIslands(int[][] grid) {
        Set<List<List<Integer>>> islands = new HashSet<>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                List<List<Integer>> island = new ArrayList<>();
                if (dfs(i, j, i, j, grid, island)) islands.add(island);
            }
        }
        return islands.size();
    }

    private boolean dfs(int i0, int j0, int i, int j, int[][] grid, List<List<Integer>> island) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] <= 0) return false;

        grid[i][j] *= -1;
        island.add(Arrays.asList(i - i0, j - j0));  // the syntax is correct. and we have to do this s.t. island has the right content
        for (int[] d : delta) dfs(i0, j0, i + d[0], j + d[1], grid, island);
        return true;
    }
}
