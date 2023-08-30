package com.practice.Medium;

import java.util.HashMap;
import java.util.Map;

public class MostStonesRemovedWithTheSameRowOrColumn {

    int count = 0;
    Map<String, String> parent;

    public int removeStones(int[][] stones) {
        parent = new HashMap<>();
        count = stones.length;
        // init Union Find
        for (int[] stone : stones) {
            String s = stone[0] + " " + stone[1];
            parent.put(s, s);
        }
        for (int[] s1 : stones) {
            for (int[] s2 : stones) {
                if (s1[0] == s2[0] || s1[1] == s2[1]) { // in the same column or row
                    union(s1[0] + " " + s1[1], s2[0] + " " + s2[1]);
                }
            }
        }
        return stones.length - count;
    }
    private void union(String s1, String s2) {
        String r1 = find(s1), r2 = find(s2);
        if (r1.equals(r2)) {
            return;
        }
        parent.put(r1, r2); //equally good if we do parent.put(r2, r1);
        count--;
    }
    private String find(String s) {
        if (!parent.get(s).equals(s)) {
            parent.put(s, find(parent.get(s)));
        }
        return parent.get(s);
    }
}
