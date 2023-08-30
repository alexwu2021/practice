package com.practice.Easy;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    /** passed oj
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; ++i){
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; ++j){
                if(board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i] !='.' && !cols.add(board[j][i]))
                    return false;
                int iq = i /3, ir = i % 3, jq = j / 3, jr = j % 3;
                int row = 3 * iq + jq, col = 3 * ir + jr;
                if(board[row][col] !='.' && !cube.add(board[row][col]))
                    return false;
            }
        }
        return true;
    }
}
