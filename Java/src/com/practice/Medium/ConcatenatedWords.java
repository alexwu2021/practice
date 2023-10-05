package com.practice.Medium;

import java.util.*;

public class ConcatenatedWords {

    /**
     * for the given s, find the starting indices of the valid substrings
     * each valid substring is made up by chaining all the words any order ==> where each word should be used once and only once
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        final List<Integer>ans = new ArrayList<>();

        final int n = s.length(), num = words.length, len = words[0].length();

        // first build a sample: this is what we expect a valid substring to have
        final Map<String, Integer> counts = new HashMap<>();
        for (final String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }



        // for each index do the scanning of the sliding window of length num * len
        for (int i = 0; i < n - num * len + 1; ++i) {
            final Map<String, Integer>seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                final String word = s.substring(i + j * len, i + (j + 1) * len);
                if (!counts.containsKey(word)) break;
                seen.put(word, seen.getOrDefault(word, 0) + 1);

                // do pruning: the current path may have used more than allowed, then stop
                if (seen.get(word) > counts.getOrDefault(word, 0)) {
                    break;
                }
                j++;
            }
            if (j == num) { // all the words have been used, so we find out a valid substring starting at i
                ans.add(i);
            }
        }
        return ans;
    }
}
