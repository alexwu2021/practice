package com.practice.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberDecoder {
    private Map<String, String> _chars;
    public NumberDecoder(){
        _chars = new HashMap<>();
        for(int i = 1; i<= 26; ++i){
            String key = String.valueOf(i);
            String value = String.valueOf((char)('a' + i - 1));
            _chars.put(key, value);
        }
    }
    List<String> decodeNumbers(String src){
        if(src == null || src.length() <= 0)
            return new ArrayList<>();
        int n = src.length();
        List<String>[] results = new List[n];
        for(int i=0; i<n; ++i)
            results[i] = new ArrayList<>();

        String first = _chars.get(src.substring(0, 1));
        results[0].add(first);

        for(int i=1; i<n; ++i){
            List<String>prev = results[i-1];
            String curr = _chars.get(String.valueOf(src.charAt(i)));

            List<String>newList = new ArrayList<>();
            for(String s: prev){
                newList.add(s + curr);
                if(i  + 1 <=n && i -2 >= 0 ) {
                    String sub = src.substring(i - 1, i+1);
                    String temp = _chars.get(sub);
                    for(String t: results[i-2]){
                        newList.add(t + temp);
                    }
                }
            }
            results[i].addAll(newList);
        }
        return results[n-1];
    }
}
