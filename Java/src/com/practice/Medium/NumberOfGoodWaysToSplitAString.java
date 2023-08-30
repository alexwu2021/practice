package com.practice.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfGoodWaysToSplitAString {
    public int numSplits(String s) {
        if(s == null || s.length()<= 1) return 0;

        // initially as a frequence counter for all the characters in s
        // gradually it ceases to be, becoming a frequency counter for the right side
        Map<Character, Integer> st = new HashMap<>();
        char[] ca = s.toCharArray();
        for(char ch: ca) st.put(ch, st.getOrDefault(ch, 0) + 1);

        int count = 0;
        Map<Character, Integer>left = new HashMap<>();
        for(char ch: ca){
            left.put(ch, left.getOrDefault(ch, 0) + 1);
            st.put(ch, st.getOrDefault(ch, 0) -1);  // adjusting the stat
            if(st.get(ch) <= 0) st.remove(ch);
            if(st.size() == left.size()) count++;
        }
        return count;
    }
}
