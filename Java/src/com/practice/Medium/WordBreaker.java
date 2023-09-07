package com.practice.Medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreaker {
    Boolean[] mem; // so we can use null to check

    public boolean wordBreak(String s, List<String> wordDict) {
        mem=new Boolean[s.length()];
        return wordBreak(s,0, new HashSet<>(wordDict));
    }

    boolean wordBreak(String s, int p, Set<String>dict){
        if(p == s.length()) return true;

        if(mem[p] != null) return mem[p];

        for(int i=p+1; i<=s.length(); ++i){ // equal -> substring(p, i) can get to and contain the end char
            if(dict.contains(s.substring(p, i)) && wordBreak(s, i, dict)){
                return mem[p] = true;
            }
        }
        return mem[p] = false;
    }
}
