package com.practice.Easy;

import java.util.HashSet;
import java.util.Set;

public class MorseCode {

    /** passed OJ at 1st attempt
     * @param words
     * @return
     */
    public int uniqueMorseRepresentations(String[] words) {
        final String[] table = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};


        Set<String> st = new HashSet<>();
        for(String word: words){
            String key = "";
            for(char ch: word.toCharArray()){
                key += table[ch - 'a'];
            }
            st.add(key);
        }
        return st.size();
    }

    }
