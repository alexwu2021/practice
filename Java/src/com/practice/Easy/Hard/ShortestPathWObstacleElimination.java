package com.practice.Easy.Hard;

//import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.
 *
 * Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.
 *
 *
 */
public class ShortestPathWObstacleElimination {

    private static int[][] dirs = new int[][]{{0,1},{1,0}, {0,-1},{-1,0}};

    // possible replacement of the above
    // int[] D = {0, 1, 0, -1, 0};
    // for (int i = 0; i < D.length - 1; ++i)
    //    int nextR = r + D[i], nextC = c + D[i + 1];


    // the following is wrong, because in extreme cases, some cell might have not been visited but left
    // behind and we have to go to the left or even up
    // this is found due to the test case #45

    //private static int[][] dirs = new int[][]{{0,1},{1,0}};

    /**
     * with reference to yuhwu's solution
     * @param grid
     * @param k
     * @return
     */
    public int shortestPath(int[][] grid, int k) {
        if(grid == null) return -1;
        int rows = grid.length;
        if(rows == 0) return -1;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList();

        // a cell can be visted one and only one time for the given unique tuple (row, col, number of obstacles to remove
        // for a certain path, ranging from 0 trhough k so it is k + 1
        boolean[][][] visited = new boolean[rows][cols][k+1];
        visited[0][0][0] = true;
        q.offer(new int[]{0,0,0});

        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; ++i){
                int[] info = q.poll();
                int r = info[0], c = info[1], curK = info[2];
                if(r==rows-1 && c==cols-1){
                    return ans;
                }
                for(int[] dir : dirs){
                    int nextR = dir[0] + r;
                    int nextC = dir[1] + c;
                    int nextK = curK;
                    if(nextR<0 || nextR>rows-1 || nextC<0 || nextC>cols-1){
                        continue;
                    }

                    // calculate nextK
                    if(grid[nextR][nextC]==1){
                        nextK++;
                    }

                    // we only mark this tuple (nextR, nextC, nextK) as visited
                    // it is not visited and it is legal to visit
                    // so not all tuples are updated all the life time
                    if(nextK<=k && !visited[nextR][nextC][nextK]){
                        visited[nextR][nextC][nextK] = true;
                        q.offer(new int[]{nextR, nextC, nextK});
                    }
                }
            }
            ans++;
        }
        return -1;
    }


    /** This is a naive implementation without pruning, that is, guided by visited
     *  and this is the reason why my solution can only solve 23 test cases out of 47
     *  and runs into TLE starting from test case 24
     * @param grid
     * @param k
     * @return
     */
    public int shortestPath_tle(int[][] grid, int k) {
        int ans = -1;
        if(grid == null) return ans;
        int rows = grid.length;
        if(rows == 0) return ans;
        int cols = grid[0].length;

        int[][][]dists = new int[rows][rows][1];
        for(int r =0; r<rows; ++r){
            dists[r] = new int[cols][1];
        }

        Queue<int[]> cells = new LinkedList<>();
        cells.add(new int[]{0, 0, k});
        int stepCount = -1;
        while(!cells.isEmpty()){
            int size = cells.size();
            for(int j=0; j<size; ++j){
                int[] curr = cells.poll();
                int row = curr[0];
                int col = curr[1];
                int remains = curr[2];
                dists[row][col][0] = Math.min(dists[row][col][0], remains);
                if(row == rows -1 && col == cols-1 && dists[row][col][0] >= 0)
                    return stepCount + 1;

                int newRemains =  grid[row][col] == 1 ?  remains-1 : remains;
                //System.out.println(String.format("row: %d, col: %d, remains: %d, parent=1 is %b newRemains: %d", row, col, remains, grid[row][col] == 1, newRemains));
                if(row + 1 < rows && col < cols)
                    cells.add(new int []{row+1, col, newRemains});
                if(row < rows && col + 1 < cols)
                    cells.add(new int []{row, col + 1, newRemains});
            }
            stepCount ++;
        }

        if(dists[rows-1][cols-1][0] >= 0)
            return stepCount;
        return -1;
    }

    //-----------------------------
    // can we do it in dfs?
}
