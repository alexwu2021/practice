package com.practice.Medium;

import java.util.HashMap;
import java.util.Map;

public class SearchAWord {

    public String find(String[] words, String s){
        Map<Character, Integer> sMap = new HashMap<>();
        for(char ch: s.toCharArray()) sMap.put(ch, sMap.getOrDefault(ch, 0) +1);

        for(String w: words) {
            Map<Character, Integer> tMap = new HashMap<>();
            for(char ch: w.toCharArray()) tMap.put(ch, tMap.getOrDefault(ch, 0) +1);

            boolean found = true;
            for (char ch : w.toCharArray()) {
                int srcFreq = sMap.getOrDefault(ch, 0);
                int tgtFreq = tMap.getOrDefault(ch, 0);
                if(srcFreq < tgtFreq) found = false;
            }
            if(found) return w;
        }
        return null;
    }
}
