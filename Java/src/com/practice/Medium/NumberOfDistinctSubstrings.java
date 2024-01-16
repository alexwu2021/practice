package com.practice.Medium;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 1698
 *
 * Given a string s, return the number of distinct substrings of s.
 *
 * A substring of a string is obtained by deleting any number of characters (possibly zero) from the front of the string and any number (possibly zero) from the back of the string.
 *
 * this problem can be solved using suffix array ( sorted array of all suffixes of a string) or Manber Myers algo
 *
 *
 */
public class NumberOfDistinctSubstrings {
    public int countDistinct(String s) {
        int ans = 1;
        long s_hash = 0, base = 1, mod = 1000000009;
        Set<Long>st = new HashSet<>();
        for (int i = 0; i + 1 < s.length(); ++i) {
            st.clear();
            s_hash = (s_hash * 26 + s.charAt(i)) % mod;
            st.add(s_hash);

            base = base * 26 % mod;
            long hash = s_hash;
            for (int j = i + 1; j < s.length(); ++j) {
                hash = (mod + hash * 26 + s.charAt(j) - base * s.charAt(j - i - 1) % mod) % mod;
                st.add(hash);
            }

            ans += st.size();
        }
        return ans;
    }
}
