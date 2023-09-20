package com.practice.Easy;

public class RemovePairs {

    int remove(String s){


        while(s.length() >= 2){
            boolean changed = false;
            for(int i=1; i<s.length(); ++i){
                if( (s.charAt(i) == '0' && s.charAt(i-1) == '1')|| (s.charAt(i) == '1' && s.charAt(i-1) == '0')){
                    String prefix =  "";
                    if (i - 1 > 0)
                        prefix = s.substring(0, i-1);

                    String postfix = "";
                    if(i + 1 < s.length())
                        postfix = s.substring(i + 1);

                    String result = prefix + postfix;
                    if(s.equals(result)) break;
                    s = result;
                    changed = true;
                }
            }
            if(!changed) break;
        }

        return s.length();
    }
}
