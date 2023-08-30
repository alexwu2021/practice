package com.practice.Easy;

public class ReverseString {

    public void reverseString(char[] s) {
        if(s == null || s.length <= 1) return;

        int mid = s.length >> 1;
        for(int i= 0; i< mid; ++i){
            char temp = s[s.length -1 - i];
            s[s.length -1 - i] = s[i];
            s[i] = temp;
        }

    }
}
