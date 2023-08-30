package com.practice.Medium;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
 */
public class GameOfLife {
    private final int [][] dirs =   {   {1,-1},{-1,1},{-1,-1},{1,1},  // the corner
                                {1,0},{-1,0},{0,1},{0,-1}     // the direct neighbors
                            };
    boolean isValid(int r, int c, int m, int n){
        if( r < 0 || r > m -1 || c < 0  || c > n-1) return false;
        return true;
    }

    /** passed oj, inspired by dream123
     *
     * // State transitions
     * //  0 : dead to dead
     * //  1 : live to live
     * //  2 : live to dead
     * //  3 : dead to live
     * @param board
     */
    public void gameOfLife(int[][] board) {
        if(board == null || board.length <= 0 || board[0].length <= 0) return;

        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                int live = 0;
                for(int[] dir : dirs){
                    int row = i + dir[0], col = j + dir[1];
                    if(!isValid(row, col, m, n)) continue;
                    if(board[row][col] == 1 || board[row][col] == 2) live++;
                }
                if(board[i][j] == 0 && live == 3) // Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
                    board[i][j] = 3;
                else if(board[i][j] == 1 && (live < 2 || live > 3)) // Any live cell with two or three live neighbors lives on to the next generation.
                    board[i][j] = 2;
            }
        }

        // shift to the next state
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j)
                board[i][j] %= 2; // use mode!!
        }
    }
}
