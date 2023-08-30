package com.practice.Medium;

import java.util.*;

public class MaxProductOfStringLength {

    /**
     *  Given a string array words, find the maximum value of length(word[i]) * length(word[j])
     *   where the two words do not share CommonTypes letters.
     * @param words
     * @return
     */
    public int maxProduct_badForSomeReason(String[] words) {
        Map<String, Set<Character>> mp = new HashMap<>();
        for(String word: words){
            Set<Character>st = new HashSet<>();
            for(Character ch: word.toCharArray()){
                st.add(ch);
            }
            mp.put(word, st);
        }

        int max = Integer.MIN_VALUE, n = words.length;
        for(int i=0; i<n-1; ++i){
            for(int j=i+ 1; j<n; ++j){
                if(
                        !mp.get(words[i]).contains(mp.get(words[j])) &&  !mp.get(words[j]).contains(mp.get(words[i]))

                ){
                    int prod = words[i].length() * words[j].length();
                    if( prod > max) max = prod;
                }
            }
        }
        return max;
    }


    /** should pass oj
     * @param words
     * @return
     */
    public static int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        int n = words.length;

        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            for(Character ch: words[i].toCharArray())
                value[i] |= 1 << (ch - 'a');
        }

        int mx = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((value[i] & value[j]) == 0)
                    mx = Math.max(mx, words[i].length() * words[j].length());
            }
        }
        return mx;
    }
}
