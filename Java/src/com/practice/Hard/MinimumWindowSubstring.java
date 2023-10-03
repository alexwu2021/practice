package com.practice.Hard;

//import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one uniqu
 *
 * Note: this should exist even faster solver than these two listed below
 *
 */
public class MinimumWindowSubstring {
    /**
     *  originally from tlj77
     *  2ms 37MB
     *
     *
     * @param S
     * @param T
     * @return
     */
    public String minWindow_faster(String S, String T) {
        String res = "";
        if (S == null || S.isEmpty() || T == null || T.isEmpty()) return res;

        int[] tmap = new int[256];
        int[] smap = new int[256];
        for (int k = 0; k < T.length(); ++k)
            tmap[T.charAt(k)]++;

        int length = Integer.MAX_VALUE;
        int i = 0, j = 0, found = 0;
        while (j < S.length()) {
            if (found < T.length()) {
                if (tmap[S.charAt(j)] > 0) {
                    smap[S.charAt(j)]++;
                    if (smap[S.charAt(j)] <= tmap[S.charAt(j)]) {
                        found++;
                    }
                }
                j++;
            }
            while (found == T.length()) {
                if (j - i < length) {
                    length = j - i;
                    res = S.substring(i, j);
                }
                if (tmap[S.charAt(i)] > 0) {
                    smap[S.charAt(i)]--;
                    if (smap[S.charAt(i)] < tmap[S.charAt(i)]) {
                        found--;
                    }
                }
                i++;
            }
        }
        return res;
    }


    /**
     *  originally from hot13399
     *  Using count.
     *     题意是找到str中最短的substring，它里面与t的所有字母对应的数量更多。
     *     比如t里面有3个A，那么substring里面至少有3个A。
     *     第一步，数一下t里面每个字母出现了多少次。
     *     第二步，move end point，找到str中满足条件的字符串。就是刚好减掉了n个，n是t的长度。
     *     第三步，move start point，去夹逼最小的substring，意思就是move start到不能往右移为止，多移一位substring就不满足条件。
     *     第四步，比较长度。
     *     第五步，把start右移一位，让substring不满足条件。
     *     回到第二步。
     *
     *
     *     7 ms  37 MB
     *
     * @param str
     * @param t
     * @return
     */
    public String minWindow(String str, String t) {
        int[] map = new int[256];
        for(char c: t.toCharArray()){
            map[c - 'A']++;
        }

        int minLen = Integer.MAX_VALUE, minStart = 0;

        int n = t.length();
        char[] sc = str.toCharArray();
        int s = 0, e = 0;
        while(e < sc.length){
            int ie = sc[e] - 'A';
            map[ie]--;
            if(map[ie] >= 0){
                n--;
            }

            if(n == 0){
                int is = sc[s] - 'A';
                while(map[is] < 0){
                    map[is]++;
                    s++;
                    is = sc[s] - 'A';
                }

                int len = e - s + 1;
                if(len < minLen){
                    minLen = len;
                    minStart = s;
                }

                map[is]++;
                s++;
                n++;
            }
            e++;
        }

        return minLen == Integer.MAX_VALUE ? "" : str.substring(minStart, minStart + minLen);
    }
}
