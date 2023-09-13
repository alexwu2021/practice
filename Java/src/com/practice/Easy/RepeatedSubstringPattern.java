package com.practice.Easy;

import java.util.ArrayList;
import java.util.List;

public class RepeatedSubstringPattern {


    /**
     * idea: reconstruct and compare
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        if(s == null || s.length() <= 1) return false;

        int n = s.length();
        for(int i = 1; i <= n/2; ++i){ // i <= n / 2
            if(n % i != 0 ) continue;

            String sub = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n/i; ++j){ // j < n/i
                sb.append(sub);
            }
            if(s.equals(sb.toString())) return true;
        }
        return false;
    }

    /**
     * Wrong implementation: can not handle cases like "abacababacab"
     * due to too strong assumption that the leading char will not appear in the pattern more than once
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern_wrong(String s) {
        if(s == null || s.length() <= 1) return false;

        char first = s.charAt(0);
        List<Integer> indices = new ArrayList<>();

        int dist = 0;
        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i) == first){
                if(i > 0){
                    dist = i - indices.get(indices.size() -1);
                    if(s.length() % dist != 0) return false;
                }
                indices.add(i);
            }
        }
        if(s.length() == indices.size()) return true;


        for(int k = 1; k<dist; ++k){
            Character nextChar = null;
            for(Integer index: indices){
                int j = index + k;
                if(j >= s.length()){
                    return false;
                }
                if(nextChar == null){
                    nextChar = (Character) (s.charAt(j));
                }else{
                    if((char)nextChar != s.charAt(j))
                        return false;
                }
            }
        }
        return true;

    }
}
