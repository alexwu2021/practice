package com.practice.Medium;

import java.util.*;
public class Palindrome4 {
    public boolean makePalindrome(String s) {
        Set<Character>st = new HashSet<>();
        Map<Character, Integer>mp = new HashMap<>();
        for(char ch: s.toCharArray()){
            st.add(ch);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        List<Character>lst = new ArrayList<>(st);
        int diff = 0;
        for(int i=0; i<lst.size()-1; ++i){
            for(int j=i + 1; j<lst.size(); ++j){

                diff += Math.abs(mp.get(lst.get(i)) - mp.get(lst.get(j))) % 2;

            }
        }

        if(diff <= 2) return true;
        return false;
    }

}
