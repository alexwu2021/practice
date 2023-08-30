package com.practice.amazon;

import java.util.*;

public class PairsOfSongs {

    public int numPairsDivisibleBy60_smartie(int[] time) {
        int c[]  = new int[60], res = 0;
        for (int t : time) {
            res += c[(600 - t) % 60];
            c[t % 60] += 1;
        }
        return res;
    }

    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int cntr = 0;
        for (int t : time) {
            cntr += map.getOrDefault((60 - t % 60) % 60, 0);
            map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
        }
        return cntr;
    }


    /** workable
     * @param times
     * @return
     */
    public int numPairsDivisibleBy60_2(int[] times) {
        Map<Integer, Integer> mp = new HashMap<>();
        int cntr = 0;
        for (int t : times) {
            int proper = t % 60;
            int cmp = (60 - proper) % 60;
            cntr += mp.getOrDefault(cmp, 0);
            mp.put(proper, mp.getOrDefault(proper, 0) + 1);
        }
        return cntr;
    }

        public int getNumberOfPairs(int[] times){
        Map<Integer, List<Integer>> valToIndices = new HashMap<>();
        for(int i = 0; i < times.length; ++i){
            valToIndices.computeIfAbsent(times[i], x ->new ArrayList<Integer>()).add(i);
        }
        Set<int[]> pairs = new HashSet<>();
        Integer[] arr = valToIndices.keySet().toArray(new Integer[valToIndices.keySet().size()]);
        for(int j=0; j<arr.length-1; ++j) {
            for(int k=j+1; k<arr.length; ++k){
                if((arr[j] + arr[k]) % 60 == 0){
                    addToSet(pairs, valToIndices.get(arr[j]), valToIndices.get(arr[k]));
                }
            }
        }
        return pairs.size();
    }

    private void addToSet(Set<int[]> pairs, List<Integer> list1, List<Integer> list2) {
        for(int j=0; j<list1.size(); ++j) {
            for(int k=0; k<list2.size(); ++k){
                pairs.add(new int[]{list1.get(j), list2.get(k)});
            }
        }
    }
}
