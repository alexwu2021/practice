package com.practice.Easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TriangleFallingSum {
    public int minimumTotal(List<List<Integer>> triangle) {
        Map<String, Integer> mp = new HashMap<>();
        return dfs(triangle, mp, 0, 0);
    }

    int dfs(List<List<Integer>> t, Map<String, Integer>mp, int i, int j){
        String key = i + "_" + j;
        if(mp.containsKey(key)){
            return mp.get(key);
        }

        if(i >= t.size()) return Integer.MAX_VALUE;
        if(j >= t.get(i).size()) return Integer.MAX_VALUE;

        int sm = t.get(i).get(j);
        if(i < t.size() -1){
            List<Integer>row = t.get(i);
            sm += Math.min(dfs(t, mp, i+1, j) , dfs(t, mp, i+1, j+1));
        }
        mp.put(key, sm);
        return sm;
    }
}
