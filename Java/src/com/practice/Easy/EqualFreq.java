package com.practice.Easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 2423, the easy version: delete one char to make char freq eqaul
 *
 * this is not 1224 (https://www.youtube.com/watch?v=nbw-jm4S1bc), which is hard
 */
public class EqualFreq {

    public boolean equalFrequency(String word) {
        for(int i=0; i<word.length(); ++i){
            StringBuilder sb = new StringBuilder(word);
            sb.deleteCharAt(i);
            String s = sb.toString();
            int[] f = new int[26];
            for(int j=0; j<s.length(); ++j){
                f[s.charAt(j)-'a']++;
            }
            Set<Integer> st = new HashSet<>();
            for(int k=0; k<26; ++k){
                if(f[k] > 0) st.add(f[k]);
            }
            if(st.size() == 1) return true;
        }
        return false;
    }

}
