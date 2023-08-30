package com.practice.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * both works
 *
 * Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["bella","label","roller"]
 * Output: ["e","l","l"]
 * Example 2:
 *
 * Input: words = ["cool","lock","cook"]
 * Output: ["c","o"]
 * 
 */
public class FindCommonCharacters {

    public List<String> commonChars_using_char_array(String[] A) {
        List<String> ret = new ArrayList<>();
        if(A == null || A.length <= 0) return ret;
        int[] base = new int[26];
        for(Character ch: A[0].toCharArray()) base[ch - 'a']++;

        for(int i = 1; i < A.length; ++i){
            int[] temp = new int[26];
            for(Character ch: A[i].toCharArray()) temp[ch - 'a']++;
            for(int j = 0; j < 26; ++j) base[j] = Math.min(base[j], temp[j]);
        }

        for(int k = 0; k < 26; ++k){
            while(base[k] > 0) ret.add("" + (char)('a' + k) );
        }
        return ret;
    }

    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;

        List<Map<Character, Integer>>maps = new ArrayList<>();
        for(int i=0; i<words.length; ++i){
            Map<Character, Integer>s = new HashMap<>();
            for(Character c: words[i].toCharArray()){
                s.put(c, s.getOrDefault(c, 0) + 1);
            }
            maps.add(s);
        }

        Map<Character, Integer>mp = maps.get(0);
        for(Map.Entry<Character, Integer>entry: mp.entrySet()){
            char ch = entry.getKey();
            int val = entry.getValue();
            boolean toInclude = true;
            for(int j=1; j< maps.size(); ++j){
                if(!maps.get(j).containsKey(ch)){
                    toInclude = false;
                    break;
                }else{
                    val = Math.min(val,maps.get(j).get(ch));
                }
            }

            if(toInclude){
                for(int i=0; i< val; ++i)
                {
                    res.add("" +ch);
                }
            }
        }
        return res;
    }
}
