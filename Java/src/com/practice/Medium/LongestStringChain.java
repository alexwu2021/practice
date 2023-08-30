package com.practice.Medium;

import java.util.*;

/**
 * You are given an array of words where each word consists of lowercase English letters.
 *
 * wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.
 *
 * For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
 * A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
 *
 * Return the length of the longest possible word chain with words chosen from the given list of words.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
 * Example 2:
 *
 * Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 * Output: 5
 * Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
 * Example 3:
 *
 * Input: words = ["abcd","dbqca"]
 * Output: 1
 * Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
 * ["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] only consists of lowercase English letters.
 *
 * failed on the second last test case due to tle
 */
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

        int n = words.length;
        Map<Integer, List<Integer>>mp = new HashMap<>();
        for(int i=0; i<n-1; ++i){
            for(int j= i+1; j<n; ++j){
                if(isPre(words, i, j)){
                    if(!mp.containsKey(i)) mp.put(i, new ArrayList<Integer>());
                    mp.get(i).add(j);
                }
            }
        }

        int mx = Integer.MIN_VALUE;
        for(int i=0; i<n; ++i){
            mx = Math.max(mx, getLength(i, mp, 1));
        }
        return mx;
    }

    private int getLength(int r, Map<Integer, List<Integer>> mp, int length){
        int ret = length;
        if(mp.containsKey(r)){
            List<Integer> lst = mp.get(r);
            for(int c: lst){
                if(r != c){
                    ret = Math.max(ret, getLength(c, mp, length+1));
                }
            }
        }
        return ret;
    }

    public boolean isPre(String[] words, int self, int other){
        if(words[self].length() >= words[other].length())
            return false;

        if(words[other].length() - words[self].length() > 1 )
            return false;

        for(int i = 0, j = 0; i < words[self].length(); ++i){
            while(j < words[other].length() && words[other].charAt(j) != words[self].charAt(i)){
                j++;
            }
            if(j == words[other].length()) return false;
            j++;
        }
        return true;
    }
}
