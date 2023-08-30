package com.practice.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *     String s = "|**|*|";
 */
public class ItemsInContain {

    private static final  char pipe = '|';
    private static final  char star = '*';


    int[] getNumberOfItems(String s, int[] startIndices, int[] endIndices){
        int n = startIndices.length;
        int[] ret = new int[n];
        Stack<Character> stk = new Stack<>();
        Map<int[], Integer> mp = new HashMap<>();

        int [] openClose = new int[2];
        for(int i = 0; i< s.length(); ++i){
            Character ch = s.charAt(i);
            if(ch == pipe){
                if(stk.isEmpty()){
                   openClose[0] = i;
                }else{
                    openClose[1] = i;
                    int si = openClose[0]+1;
                    int e = openClose[1]-1;
                    if(e >= si){
                        mp.put(new int[]{si, e}, stk.size());
                    }
                    while(!stk.isEmpty())
                        stk.pop();
                    openClose[0] = i;
                }
            }else{
                if(ch == star)
                    stk.push(ch);
            }
        }

        for(int j = 0; j < n; ++j){
            int start = startIndices[j] -1 ;
            int end = endIndices[j] -1;
            for(int[] key : mp.keySet()){
                if(key[0] > start && key[1] < end){
                    ret[j] += mp.get(key);
                }
            }
        }
        return ret;
    }
}
