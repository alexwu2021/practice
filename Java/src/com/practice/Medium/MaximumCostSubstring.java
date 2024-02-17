package com.practice.Medium;

import java.util.*;
public class MaximumCostSubstring {



        public int maximumCostSubstring(String s, String chars, int[] vals) {
            int ans = 0, currSoFar = Integer.MIN_VALUE;
            int dict[] = new int[26]; // (char - 'a') <-> val
            Arrays.fill(dict, Integer.MIN_VALUE);
            for(int i=0; i<chars.length(); ++i)
                dict[chars.charAt(i) - 'a'] = vals[i];

            for(int j=0; j<s.length(); ++j){
                int key = s.charAt(j) - 'a', val = key + 1;
                if(dict[key] != Integer.MIN_VALUE){
                    val = dict[key];
                }
                if(currSoFar < 0 && currSoFar < val){
                    currSoFar = val;
                } else {
                    currSoFar += val;
                }
                ans = Math.max(ans, currSoFar);
            }
            return ans;
        }

        public int maximumCostSubstring_quicker(String s, String chars, int[] vals) {
            int n = s.length(), sum = 0, max = Integer.MIN_VALUE;
            int counts[] = new int[26];
            Arrays.fill(counts, Integer.MIN_VALUE);

            for(int i=0; i<chars.length(); ++i)
                counts[chars.charAt(i) - 'a'] = vals[i];

            int[] ss = new int[n];
            for(int i=0; i<s.length(); ++i){
                char c = s.charAt(i);
                if(counts[c - 'a'] != Integer.MIN_VALUE)
                    ss[i] = counts[c - 'a'];
                else
                    ss[i] = c - 'a' + 1;
            }

            //kadane's algorithm
            for(int i=0; i<ss.length; ++i){
                sum += ss[i];
                if(max <= sum )
                    max = sum;
                if(sum < 0)
                    sum = 0;
            }
            return max < 0 ? 0 : max;
        }

    public int maximumCostSubstring_slower(String s, String chars, int[] vals) {
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
