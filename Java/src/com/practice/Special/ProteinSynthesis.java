package com.practice.Special;

import java.util.Map;

public class ProteinSynthesis {
    public String GetMutated(int n, int k, String proteins, Map<String, Character> mp){
        char[] ca = proteins.toCharArray();
        for(int i=0; i<k; i++){
            int pos = 1;
            char ch = ca[0];
            while(pos <n){
                ca[pos-1] = mp.get(ca[pos-1] +""+ ca[pos]);
                pos++;
            }
            ca[n-1] = mp.get(ca[n-1]+""+ch);
        }
        return String.valueOf(ca);
    }
}
