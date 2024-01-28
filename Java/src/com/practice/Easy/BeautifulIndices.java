package com.practice.Easy;

import java.util.*;


/**
 * 3006, need use kmp to solve it
 */
public class BeautifulIndices {


        /**
         * kmp algo
         *
         * @param s
         * @param
         */
        List<Integer> getPatternMatchingIndex(String s, String t){
            List<Integer> v = new ArrayList<>();
            String x = t + "@" + s;
            List<Integer> lps = new ArrayList<>();
            lps.add(0);
            for(int i = 1; i < x.length(); ++i){
                int ind = lps.get(i - 1);
                while(ind > 0 && x.charAt(ind) != x.charAt(i)) {
                    ind = lps.get(ind - 1);
                }
                lps.add((x.charAt(ind) == x.charAt(i)) ? ind + 1 : 0);
            }
            for(int i = 0; i < lps.size(); ++i){
                if(lps.get(i) == t.length())
                    v.add(i - 2*t.length());
            }
            return v;
        }

        public List<Integer> beautifulIndices(String s, String a, String b, int k) {
            List<Integer> ans = new ArrayList<>();
            List<Integer> v1 = getPatternMatchingIndex(s, a), v2 = getPatternMatchingIndex(s, b);
            for(int i = 0, j = 0; i < v1.size(); ++i){
                while(j < v2.size() && v1.get(i) > v2.get(j) && Math.abs(v1.get(i) - v2.get(j)) > k){
                    j++;
                }
                if(j < v2.size() && Math.abs(v1.get(i) - v2.get(j)) <= k)
                    ans.add(v1.get(i));
            }
            return ans;
        }



    public List<Integer> beautifulIndices_tle(String s, String a, String b, int k) {
        Set<Integer>res = new HashSet<>();
        List<Integer>aIndices = getIndices(s, a), bIndices = getIndices(s, b);
        for(int j=0; j<bIndices.size(); ++j){
            for(int i=0; i<aIndices.size(); ++i){
                if(Math.abs(bIndices.get(j) - aIndices.get(i)) <= k){
                    res.add(aIndices.get(i));
                }
            }
        }
        List<Integer>ans = new ArrayList<>(res);
        Collections.sort(ans);
        return ans;
    }

    private List<Integer>getIndices(String s, String t){
        List<Integer>indices = new ArrayList<>();
        int idx = s.indexOf(t);
        while(idx >= 0){
            indices.add(idx);
            idx = s.indexOf(t, idx + t.length());
        }
        return indices;
    }
}
