package com.practice.Easy;

import java.util.*;

/**
 *
 */
public class TwoLists {

    /**
     *
     * Write a function that takes this data as input and returns two
     * collections: one containing all individuals with zero known parents, and one
     * containing all individuals with exactly one known parent.
     *
     * @param parentChildPairs
     * @return
     */
    public List<Integer>[] findNodesWithZeroAndOneParents(List<int[]> parentChildPairs){
        List<Integer>[] ret = new ArrayList[2];
        for(int i = 0; i <= 1; ++i){
            ret[i] = new ArrayList<>();
        }

        Map<Integer, List<Integer>> mp = new HashMap<>();
        Set<Integer> allNodes = new HashSet<>();

        for(int[] pair : parentChildPairs){
            int parent = pair[0];
            int child = pair[1];
            mp.computeIfAbsent(child, x ->new ArrayList<Integer>()).add(parent);
            allNodes.add(parent);
            allNodes.add(child);
        }

        for(Integer node : allNodes){
            if(!mp.containsKey(node)){
                ret[0].add(node);
                continue;
            }
            List<Integer> values = mp.get(node);
            if(values.size() == 1)
                ret[1].add(node);
        }
        Collections.sort(ret[0]);
        Collections.sort(ret[1]);
        return ret;
    }
}
