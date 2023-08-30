package com.practice.Easy;

import java.util.HashMap;
import java.util.Map;

public class RemoveAlternateDups {

    public void removeAlternateDuplicates(char[] ret){

        Map<Character, Integer> ch2Idx = new HashMap<>();
        int n = ret.length;
        int i = 0;
        for(i=0; i<n; ++i ){
            ch2Idx.put(ret[i], ch2Idx.getOrDefault(ret[i], 0) + 1);
            if(ch2Idx.get(ret[i]) > 1 && ch2Idx.get(ret[i]) % 2 == 0){
                ret[i] = '\0';
            }
        }

        i = 0;
        int j = i + 1;
        for(; i<n-1 && j <n;){
            if(ret[i] == '\0'){
                while(j < n && ret[j] == '\0' ){
                    j++;
                }
                ret[i] = ret[j];
                ret[j] = '\0';
                i++;
                j++;
            }else{
                i++;
                j++;
            }
        }

        if(i == n-2 ){
            if(ret[n-1] != '\0' && ret[i] == '\0'){
                ret [i]= ret[n-1];
                ret[n-1] = '\0';
            }
        } else {
            for(; i<n; ++i)
                ret[i] = '\0';
        }

    }
}
