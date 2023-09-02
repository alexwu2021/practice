package com.practice.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrayCode {
    private int MAX;
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        Set<Integer> set = new HashSet<>();
        set.add(0);
        dfs(res, n, set);

        MAX = 1 << n;
        return res;
    }
    private void dfs(List<Integer> res, int n, Set<Integer> st) {
        if (res.size() == MAX) return;
        for (int i = 0; i < n; ++i) {
            int prev = res.get(res.size()-1);
            int cur = prev ^ (1 << i);
            if (!st.contains(cur)) {
                st.add(cur);
                res.add(cur);
                dfs(res, n, st);
            }
        }
    }
}
