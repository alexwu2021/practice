package com.practice.Medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Example 4:
 *
 * Input: s = ""
 * Output: 0
 */
public class LongestSubstringWithoutRepeats {
    public int lengthOfLongestSubstring(String s) {
        int i=0, j=0, mx = 0;
        Set<Character> st = new HashSet<>();
        while(j <s.length()){
            if(!st.contains(s.charAt(j))){
                st.add(s.charAt(j++));
                mx = Math.max(mx, st.size());
            }else{
                st.remove(i++);
            }
        }
        return mx;
    }

    public int lengthOfLongestSubstring_ON2(String s) {
        int mx = 0;
        Queue<Character> q = new LinkedList<>();
        for(char ch: s.toCharArray()){
            while(q.contains(ch)) q.poll();
            q.offer(ch);
            mx = Math.max(mx, q.size());
        }
        return mx;
    }

}
