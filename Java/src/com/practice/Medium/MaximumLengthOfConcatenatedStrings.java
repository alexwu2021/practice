package com.practice.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1239. Maximum Length of a Concatenated String with Unique Characters
 *
 */
public class MaximumLengthOfConcatenatedStrings {

/*
    def maxLength(self, A):
        dp = [set()]
        for a in A:
            if len(set(a)) < len(a): continue
            a = set(a)
            for c in dp[:]:
                if a & c: continue
                dp.append(a | c)
        return max(len(a) for a in dp)
 */


    public int maxLength(List<String> A) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int res = 0;

        for (String s : A) {
            int a = 0, dup = 0;
            for (char c : s.toCharArray()) {
                dup |= a & (1 << (c - 'a'));
                a |= 1 << (c - 'a');
            }
            if (dup > 0) continue;

            for (int i = dp.size() - 1; i >= 0; --i) {
                if ((dp.get(i) & a) > 0) continue;
                dp.add(dp.get(i) | a);
                res = Math.max(res, Integer.bitCount(dp.get(i) | a));
            }
        }
        return res;
    }


}
