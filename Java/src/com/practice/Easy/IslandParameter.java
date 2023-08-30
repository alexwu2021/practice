package com.practice.Easy;

public class IslandParameter {

    /** the key point is that the paramter is the 4 * isLandCount - 2 * (rightNeighborCount
     * + downNeighborCount)
     *
     *  passed the OJ
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid[0].length <= 0) return 0;

        int rows = grid.length, cols = grid[0].length;

        int ret = 0;
        int icount = 0, ncount = 0;
        for(int i = 0; i< rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(grid[i][j] == 1){
                    icount++;
                    if(i + 1 < rows){
                        if(grid[i+1][j] == 1) ncount++;
                    }

                    if(j  + 1 < cols)
                    {
                        if(grid[i][j+1] == 1) ncount++;

                    }

                }

            }

        }
        ret = 4* icount - 2 * ncount;
        return ret;
    }
}
