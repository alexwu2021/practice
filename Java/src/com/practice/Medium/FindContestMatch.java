package com.practice.Medium;

import java.util.ArrayList;
import java.util.List;

public class FindContestMatch {

    /** passed oj
     * @param n
     * @return
     */
    public String findContestMatch(int n) {
        List<String>lst = new ArrayList<>();
        for(int i = 0 + 1; i<= n; ++i) lst.add("" + i);
        StringBuilder sb = new StringBuilder();
        dfs(lst, sb);
        return sb.toString();
    }

    private void dfs(List<String> lst, StringBuilder sb){
        if(lst.size() == 2){
            sb.append("(" + lst.get(0) + "," + lst.get(1) + ")");
            return;
        }

        List<String>result = new ArrayList<>();
        int n = lst.size();
        int m = n >> 1;
        for(int i = 0; i < m ; ++i) result.add("(" + lst.get(i) + "," + lst.get(n - 1 - i) + ")");
        dfs(result, sb);
    }
}
