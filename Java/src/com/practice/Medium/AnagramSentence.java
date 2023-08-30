package com.practice.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramSentence {
    boolean isAnagramSentence(String s, String t){
        String[] sa = s.split(" ");
        String[] ta = t.split(" ");
        Map<String, Integer> smp = new HashMap<>();
        Map<String, Integer> tmp = new HashMap<>();

        for(String str: sa){
            smp.put(treat(str), smp.getOrDefault(str, 0) + 1);
        }
        for(String str: ta){
            tmp.put(treat(str), tmp.getOrDefault(str, 0) + 1);
        }

        if(smp.size() != tmp.size())
            return false;
        for(Map.Entry<String, Integer>ent: smp.entrySet()){
            if(!tmp.containsKey(ent.getKey()))
                return false;
            if(tmp.get(ent.getKey()) != ent.getValue())
                return false;
        }
        return true;
    }

    String treat(String s){
        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        return String.valueOf(ca);
    }

}
