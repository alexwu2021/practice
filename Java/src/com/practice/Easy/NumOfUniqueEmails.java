package com.practice.Easy;

import java.util.HashSet;
import java.util.Set;

public class NumOfUniqueEmails {

    public int numUniqueEmails(String[] emails) {
        final String AT = "@";
        Set<String> st = new HashSet<>();
        for(String email: emails) {
            String[]strs = email.split(AT , 2);
            String key = strs[0].replace(".", "");
            if(key.indexOf("+") >= 0){
                st.add(key.substring(0, key.indexOf("+")) + AT + strs[1]);
            } else {
                st.add(key + AT +  strs[1]);
            }
        }
        return st.size();
    }
}
