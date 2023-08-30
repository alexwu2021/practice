package com.practice.companies.amazon;

import java.util.*;

/**
 *  Substrings of size K with K distinct chars
 */
public class DistinctSubstringOfSizeK {

    private String getNullOrValidString(char[]src, int n, int start, int end, int k){
        if (end > n-1)
            return null;
        String ret = "";
        Set<Character>st = new HashSet<>();
        for(int i=start; i<= end; ++i){
            ret += src[i];
            st.add(src[i]);
        }
        if(st.size() != k)
            return null;
        return ret;
    }

    public List<String> getListOfDistinctSubstringOfSizeK_mine(char[] src, int k){
        List<String> ret = new ArrayList<>();
        Set<Character> st = new HashSet<>();
        int n = src.length;
        for(int i = 0; i< n - k + 1; i++){
            String temp = getNullOrValidString(src, n, i, i + k -1, k);
            if(temp != null)
                ret.add(temp);
        }
        return ret;
    }

    public List<String> getListOfDistinctSubstringOfSizeK(char[] src, int k){
        Set<String> st = uniqueSubstringSizeK(new String(src), k);
        return new ArrayList<>(st);
    }

    public static Set<String> uniqueSubstringSizeK(String s, int k) {
        Set<String> set = new HashSet<>();
        int[] ch = new int[26];
        int lo=0;
        int hi=0;
        while(lo<=hi && hi<s.length()) {
            ch[s.charAt(hi)-'a']++;
            while(ch[s.charAt(hi)-'a'] != 1) {
                ch[s.charAt(lo)-'a']--;
                lo++;
            }
            if(hi-lo+1 == k) {
                set.add(s.substring(lo, hi+1));
                ch[s.charAt(lo)-'a']--;
                lo++;
            }
            hi++;
        }
        System.out.println(set.size());
        Iterator<String> it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        return set;
    }
}
