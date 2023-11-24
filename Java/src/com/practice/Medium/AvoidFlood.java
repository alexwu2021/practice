package com.practice.Medium;

import java.util.*;
public class AvoidFlood {


    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] parent = new int[n], result = new int[n];
        for(int i = 0; i < n; ++i){
            parent[i] = i;
            result[i] = -1;
        }

        Map<Integer, Integer> last = new HashMap<>(n);
        for (int i = 0; i < n; ++i) {
            if (rains[i] > 0) {
                Integer index = last.put(rains[i], i);
                if (index == null)
                    continue;

                index = find(parent, index);
                while (index < i && (rains[index] > 0 || result[index] != -1)) {
                    parent[index] = index + 1;
                    index = find(parent, index);
                }

                if (index >= i)
                    return new int[0];

                result[index] = rains[i];
            }
        }

        for (int i = 0; i < n; ++i) {
            if (result[i] == -1 && rains[i] == 0)
                result[i] = 1;
        }

        return result;
    }

    private int find(int[] parent, int x) {
        return  parent[x] == x ? x : (parent[x] = find(parent, parent[x]));
    }
    public int[] avoidFlood_treeSetVersion(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        int index = 0;
        Map<Integer, Integer> lake2fullDay = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[index++] = 1;
            } else {
                int lake = rains[i];
                if (lake2fullDay.containsKey(lake)) {
                    // find a day in "drydays" to dry this lake.
                    Integer day = dryDays.higher(lake2fullDay.get(lake));
                    if (day == null) {
                        //couldn't stop flooding.
                        return new int[]{};
                    }
                    ans[day] = lake;
                    dryDays.remove(day);
                }
                lake2fullDay.put(lake, i);
                ans[index++] = -1;
            }
        }
        return ans;
    }

}
