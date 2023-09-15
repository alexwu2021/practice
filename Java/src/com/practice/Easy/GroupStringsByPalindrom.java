package com.practice.Easy;

import java.util.*;
import java.util.stream.Collectors;

public class GroupStringsByPalindrom {

    public List<List<String>> groupStringsByAnagram(List<String>inputs ) {
        List<List<String>> ans = new ArrayList<>();

        Map<String, Integer> mp = new HashMap<>();
        for(String input : inputs){
            List<Character>lst = input.chars().mapToObj(e->(char)e).collect(Collectors.toList());

            Set<Character>st = new HashSet<>(lst); // interesting, there is no need to sort, and the resulting set always comes in lexicographical order

            String key = st.stream()
                    .map(n -> String.valueOf(n))
                    .collect(Collectors.joining("_"));
            int index = mp.getOrDefault(key, -1);
            if(index != -1){
                ans.get(index).add(input);
            }else {
                List<String> tempList = new ArrayList<>();
                tempList.add(input);
                ans.add(tempList);
                mp.put(key, ans.size()-1);
            }
        }
        return ans;
    }

}
