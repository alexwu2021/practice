package com.practice.Medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * #542
 *
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 * Example 2:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,1,1]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,2,1]]
 *
 *
 * Note:
 *
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 */
public class ZeroOneMatrix {

    private static final int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private Queue<int[]> taskQ = new LinkedList<>();
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix[0].length <= 0) return matrix;

        int m = matrix.length, n = matrix[0].length;
        boolean [][] visited = new boolean[m][n];

        for(int i =  0; i < m; ++i){
            for(int j =  0; j < n; ++j){
                visited[i][j] = (matrix[i][j] == 1) ? false : true;
                if(!visited[i][j]) taskQ.offer(new int[]{i, j});
            }
        }

        for(int[] cell: taskQ) bfs(matrix, cell[0], cell[1], visited);

        return matrix;
    }

    private boolean isValid(int[][] matrix, int r, int c){
        return (r < 0 || r > matrix.length-1 || c < 0 || c > matrix[0].length -1) ? false : true;
    }

    private void bfs(int[][] matrix, int i, int j, boolean[][] visited){
        visited[i][j] = true;

        Queue<int[]> q = new LinkedList<>();
        for(int[] dir : dirs) q.offer(new int[]{i + dir[0], j + dir[1]});

        int dist = Integer.MAX_VALUE;
        int iteration = 0;
        while(!q.isEmpty()){
            iteration++;
            int currQSize = q.size();
            for(int k = 0; k < currQSize; ++k){
                int[] front = q.poll();
                int row = front[0], col = front[1];
                if(!isValid(matrix, row, col)) continue;
                if(matrix[row][col] == 0){
                    matrix[i][j] = Math.min(dist, iteration);
                    return;
                }

                for(int[] dir : dirs) q.offer(new int[]{row + dir[0], col + dir[1]});
            }
        }
    }



    //---------------------------------
    /** OJ passed with runtime at 38 ms, memory at 48 MB
     * @param matrix
     * @return
     */
    public int[][] updateMatrixSlowerVersion(int[][] matrix) {
        if(matrix == null || matrix[0].length <= 0) return matrix;

        int m = matrix.length, n = matrix[0].length;
        boolean [][] visited = new boolean[m][n];

        for(int i =  0; i < m; ++i){
            for(int j =  0; j < n; ++j){
                visited[i][j] = (matrix[i][j] == 1) ? false : true;
            }
        }

        for(int i =  0; i < m; ++i){
            for(int j =  0; j < n; ++j){
                if(!visited[i][j]) bfs(matrix, i, j, visited);
            }
        }

        return matrix;
    }

}
