package com.practice.Medium;

/**
 * Let's play the minesweeper game (Wikipedia, online game)!
 *
 * You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.
 *
 * Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:
 *
 * If a mine ('M') is revealed, then the game is over - change it to 'X'.
 * If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
 * If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
 * Return the board when no more squares will be revealed.
 *
 *
 * Example 1:
 *
 * Input:
 *
 * [['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'M', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E']]
 *
 * Click : [3,0]
 *
 * Output:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 */
public class MineSweeper {

    static final int[][] cords = {{-1,0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    /** inspired by https://forum.letstalkalgorithms.com/t/minesweeper/410
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board == null || board.length==0) return board;
        int row = click[0], col = click[1];
        if(board[row][col]=='M'){
            board[row][col] = 'X';
            return board;
        }
        dfs(board, row, col);
        return board;
    }

    private void dfs(char[][] board, int row, int col){
        if(!validIndexes(board, row, col) || board[row][col] != 'E') return;
        int mines = getMines(board, row, col);
        if(mines>0) {
            board[row][col] = (char) ('0' + mines);
            return;
        }
        // by definition, now E --> B
        board[row][col] = 'B';
        for(int[] cord : cords){
            int nr = row+cord[0], nc = col + cord[1];
            dfs(board, nr, nc);
        }
    }

    private boolean validIndexes(char[][] board, int row, int col){
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;
        return true;
    }

    private int getMines(char[][] board, int row, int col){
        int mines = 0;
        for(int[] cord : cords){
            int nr = row + cord[0], nc = col + cord[1];
            if(validIndexes(board, nr, nc) && (board[nr][nc] == 'M' || board[nr][nc] == 'X')){
                mines++;
            }
        }
        return mines;
    }
}
