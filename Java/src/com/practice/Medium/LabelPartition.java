package com.practice.Medium;

import java.util.*;

public class LabelPartition {

    /**
     * 116 / 116 test cases passed.
     * Status: Accepted
     * Runtime: 52 ms
     * Memory Usage: 39.3 MB
     * the idea is continuously relaxing the right end index such that we find a first admitable string
     * and continue till we reach the end of the input string
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if(S == null || S.length() <= 0)
            return res;
        Map<Character, List<Integer>> mp = new HashMap<>();
        for(int i = 0; i < S.length(); ++i){
            mp.computeIfAbsent(S.charAt(i), x -> new ArrayList<>()).add(i);
        }
        return dfs(S, 0, mp);
    }


    /**
     * continuously relaxing the right end
     *
     * @param S
     * @param start
     * @param mp
     * @return
     */
    List<Integer> dfs(String S, int start, Map<Character, List<Integer>> mp) {
        List<Integer> res = new ArrayList<>();
        if(start >= S.length())
            return res;

        Character ch = S.charAt(start);
        List<Integer>lst = mp.get(ch);
        if(lst.size() == 1){
            res.add(1);
            res.addAll(dfs(S, start + 1, mp));
            return res;
        }

        Collections.sort(lst);
        int end = lst.get(lst.size() - 1);

        //for current OJ, have to use the following
        for(int j = start + 1; j < end; ++j){
            List<Integer>tempList = mp.get(S.charAt(j));
            for(Integer tl: tempList)
                if (tl > end)
                    end = tl;
        }

        // it is poissble to use the following way to get max
//        for(int j = start + 1; j < end; ++j){
//            OptionalInt temp = mp.get(S.charAt(j)).stream().mapToInt(v->v).max();
//            if(temp.getAsInt() >  end){
//                end = temp.getAsInt();
//            }
//        }

        res.add(end - start + 1);
        res.addAll(dfs(S, end + 1, mp));
        return res;
    }
}
