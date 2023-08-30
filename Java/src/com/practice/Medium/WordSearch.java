package com.practice.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
 * vertically neighboring. The same letter cell may not be used more than once.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 *
 * Constraints:
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length <= 0 || board[0].length <= 0) return false;
        for (int r=0; r<board.length; r++) {
            for (int c=0; c<board[r].length; c++) {
                if (dfs(board, r, c, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int r, int c, String word, int level) {
        if (level == word.length()) return true;
        boolean ret = false;
        if (r >= 0 && r < board.length && c >= 0 && c <board[0].length
                && level < word.length() && board[r][c] == word.charAt(level)) {
            //board[r][c] ^= Integer.MAX_VALUE;
            char ch = board[r][c];
            board[r][c] = '&';
            ret =  dfs(board, r + 1, c, word , level+1)
                    || dfs(board, r, c +1, word , level+1)
                    || dfs(board, r - 1, c, word , level+1)
                    || dfs(board, r, c-1, word , level+1);
            board[r][c] = ch;
            //board[r][c] ^= Integer.MAX_VALUE;
        }
        return ret;
    }
}
