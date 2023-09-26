package com.practice.Easy.Hard;

import java.util.*;

public class InvalidParentheses {
    private static final char[] PAR = new char[]{'(', ')'};
    private static final char[] REV_PAR = new char[]{ ')', '('};


    /** passed oj
     * @param s
     * @param ans
     * @param last_i
     * @param last_j
     * @param par
     */
    private void remove(String s, List<String>ans, int last_i, int last_j, char[] par){
        int stack = 0, i = last_i, j = last_j;
        for(; i < s.length(); ++i){
            if(s.charAt(i) == par[0]) stack++;
            if(s.charAt(i) == par[1]) stack--;
            if(stack >= 0) continue;
            for(; j <= i; ++j){
                if(s.charAt(j) != par[1]) continue;
                if(j == last_j || s.charAt(j - 1) != par[1]) remove(s.substring(0, j) + s.substring(j + 1), ans, i, j, par);
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if(par[0] == PAR[0]) remove(reversed, ans, 0, 0, REV_PAR);
        else ans.add(reversed);
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, PAR);
        return ans;
    }
}
