package com.practice.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagramMappings {


    /** passed oj
     * @param A
     * @param B
     * @return
     */
    public int[] anagramMappings(int[] A, int[] B) {
        int [] ans = new int[A.length];
        if(A == null || B == null || A.length != B.length || A.length == 0) return ans;

        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < B.length; ++i) mp.put(B[i], i);

        int k = 0;
        for (int a : A) ans[k++] = mp.get(a);

        return ans;
    }

    public int[] anagramMappingsWithoutWriteAfterWrite(int[] A, int[] B) {
        int [] ans = new int[A.length];
        if(A == null || B == null || A.length != B.length || A.length == 0) return ans;

        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i = 0; i < B.length; ++i)
            mp.computeIfAbsent(B[i], x -> new ArrayList<>()).add(i);

        int k = 0;
        for (int a : A) {
            List<Integer> lst = mp.get(a);
            for(int j = 0; j < lst.size(); ++j){
                int idx = lst.get(j);
                if( idx != Integer.MAX_VALUE) {
                    ans[k++] = idx;
                    lst.set(j, Integer.MAX_VALUE);
                }
            }
            mp.put(a, lst);
        }
        return ans;
    }
}
