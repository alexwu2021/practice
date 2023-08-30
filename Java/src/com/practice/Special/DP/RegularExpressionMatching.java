package com.practice.Special.DP;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        int m = s.length(), n = p.length();
        boolean[][] M = new boolean[m + 1][n + 1];
        M[0][0] = true;
        for(int j = 2; j < n + 1; j +=2){
            if(p.charAt(j - 1) == '*' && M[0][j - 2]) M[0][j] = true;
        }

        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                char curS = s.charAt(i - 1);
                char curP = p.charAt(j - 1);

                if('.' == curP || curS == curP){
                    M[i][j] = M[i-1][j-1];
                    continue;
                }

                if('*' == curP){
                    char prevCurP = p.charAt(j-2);
                    if(prevCurP != '.' && prevCurP != curS){
                        M[i][j] = M[i][j-2];
                    } else {// either .* or (a certain char)*
                        M[i][j] = M[i][j-2]         // pat is empty
                                || M[i-1][j]        // treat * as +
                                || M[i-1][j-2];     // drop one char from s by consuming 2 char pattern: either .*  or (a certain char)*, used in the sense of 1 char equivalent
                    }
                }
            }
        }
        return M[m][n];
    }
}
