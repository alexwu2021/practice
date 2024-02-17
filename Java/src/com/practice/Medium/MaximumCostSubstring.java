package com.practice.Medium;

import java.util.*;
public class MaximumCostSubstring {

    public int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Character, Integer>mp = new HashMap<>();
        int n = chars.length(), ans = 0, currSoFar = Integer.MIN_VALUE;
        for(int i=0; i<n; ++i){
            mp.put(chars.charAt(i), vals[i]);
        }

        for(int j=0; j<s.length(); ++j){
            int val = s.charAt(j) - 'a' + 1;
            if(mp.containsKey(s.charAt(j))){
                val = mp.get(s.charAt(j));
            }

            if(currSoFar < 0 && currSoFar < val){
                currSoFar = val;
            }else{
                currSoFar += val;
            }
            ans = Math.max(ans, currSoFar);
        }

        return ans;

    }
}
