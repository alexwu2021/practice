package Medium;

public class MaxAreaOfIslands {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length <= 0 || grid[0].length <= 0) return 0;
        int mx = 0; // cannot be Integer.MIN_VALUE;
        for(int r = 0; r < grid.length; ++r){
            for(int c = 0; c < grid[0].length; ++c){
                if(grid[r][c] != 1) continue;
                int temp = dfs(grid, r, c);
                mx = Math.max(mx, temp);
            }
        }
        return mx;
    }

    private int dfs(int[][] grid, int r, int c){
        if( r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1){
            grid[r][c] = 0;
            return 1 + dfs(grid, r+1, c) + dfs(grid, r-1, c) + dfs(grid, r, c-1) + dfs(grid, r, c+1);
        }
        return 0;
    }


    /**
     * TODO: need finding out why this does not work, due to index out of boundary
     *
     * @param grid
     * @param r
     * @param c
     * @return
     */
    private int dfs_falty(int[][] grid, int r, int c){
        if(r > grid.length || r < 0 || c > grid[0].length || c < 0  || grid[r][c] != 1){
            return 0;
        }
        grid[r][c] = 0;
        return 1 + dfs(grid, r +1, c) + dfs(grid, r, c+1)+ dfs(grid, r -1, c)+ dfs(grid, r, c-1);
    }
}
