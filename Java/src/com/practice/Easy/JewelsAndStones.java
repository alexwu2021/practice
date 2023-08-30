package com.practice.Easy;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    /** borrowed from s pochmann
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones_passedOJ(String J, String S) {
        return S.replaceAll("[" + J + "]", "").length();
    }


    /** this implementation shed the light:
     *  any single letter in J is a single jewelery
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        Set<Character> jSet = new HashSet<>();
        for(char j : J.toCharArray()){
            jSet.add(j);
        }

        int jCount = 0;
        for(char s : S.toCharArray()){
            if(jSet.contains(s)){
                jCount++;
            }
        }
        return jCount;
    }

    int numJewelsInStones_ref(String J, String S) {
        int i = 0, k = 0, sum = 0;
        while (i < S.length()) {
            k = 0;
            while (k < J.length()) {
                if (J.charAt(k) == S.charAt(i)) {
                    sum++;
                    break;
                }
                k++;
            }
            i++;
        }
        return sum;
    }
}
