package com.practice.Medium;


import java.util.*;

public class BeautifulSubstring {
    public int beautifulSubstrings(String s, int k) {
        int ans = 0, cCount, vCount;
        for (int i = 0; i < s.length(); ++i) {
            cCount = 0;
            vCount = 0;
            for (int j = i; j < s.length(); ++j) {
                char c = s.charAt(j);
                if (isInVowelSet(c)) {
                    vCount++;
                }else{
                    cCount++;
                }
                if (cCount == vCount && (cCount * vCount) % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isInVowelSet(char c) {
        if(c == 'a' || c=='A' || c == 'e' || c=='E' || c == 'u' || c=='U'|| c == 'i' || c=='I'|| c == 'o' || c=='O'){
            return true;
        }
        return false;
    }
}
